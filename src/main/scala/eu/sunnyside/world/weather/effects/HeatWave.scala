package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.tools.Dice
import eu.sunnyside.world._
import eu.sunnyside.world.time.Date
import eu.sunnyside.world.weather._

/**
 * For the next 3-8 days (ld6 +2), starting with the day in question, the temperature will rise at the rate of 4 steps 
 * per day until it reaches a high point one step above the normal maximum temperature
 */
object HeatWave extends SpecialWeather {
  
  val code = 'Z'
  def duration = 2 + Dice.roll(6)
  val indefinite = false
  val priority = 10
  
  override def influence(w: Weather, wp: Weather, l: Location, d: Date, dt: Int, dp: Int): Weather = {
        
    val temperature = {
      val maxMonth = MonthlyTemperatureRanges(l.climate, l.terrain, d.month).max
      val maxAllowed = maxMonth.step(1)
      
      if (wp.temperatureRange.code <= 'W') {
        val raised = wp.temperatureRange.step(4)
        if (raised.code > maxAllowed.code) maxAllowed
        else raised
      }
      else maxAllowed
    }
    
    val oe = w.findEffect(this)
    if (temperature.code == '[' && oe.daysLeft > 3) {
      val reducedDuration = oe.daysPassed + 3 
      w.applyTemperatureRangeChange(temperature).removeEffect(this).addOngoingEffect(new OngoingEffect(this, reducedDuration, oe.daysPassed))
    }
    else w.applyTemperatureRangeChange(temperature)
  }
  
  override def onExit = new EffectHasEnded(this)
  
  override def description = "A Heat Wave is in progress."
  override def toString = "Heat Wave"

}
