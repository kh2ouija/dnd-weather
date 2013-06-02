package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.tools.Dice
import eu.sunnyside.world._
import eu.sunnyside.world.time.Date
import eu.sunnyside.world.weather._

/**
 * For the next 3-8 days (1d6+2), starting with the day in question, the temperature will drop at the rate of 4 steps
 * per day until it reaches a low point one step below the normal minimum temperature
 */
object ColdWave extends SpecialWeather {
  
  val code = 'A'
  def duration = 2 + Dice.roll(6)
  val indefinite = false
  val priority = 10
  
  override def influence(w: Weather, wp: Weather, l: Location, d: Date, dt: Int, dp: Int): Weather = {
        
    val temperature = {
      val minMonth = MonthlyTemperatureRanges(l.climate, l.terrain, d.month).min
      val minAllowed = minMonth.step(-1)
      
      if (wp.temperatureRange.code >= 'D') {
        val lowered = wp.temperatureRange.step(-4)
        if (lowered.code < minAllowed.code) minAllowed
        else lowered
      }
      else minAllowed
    }
    
    val oe = w.findEffect(this)
    if (temperature.code == '@' && oe.daysLeft > 3) {
      val reducedDuration = oe.daysPassed + 3 
      w.applyTemperatureRangeChange(temperature).removeEffect(this).addOngoingEffect(new OngoingEffect(this, reducedDuration, oe.daysPassed))
    }
    else w.applyTemperatureRangeChange(temperature)
  }
    
  override def onExit = new EffectHasEnded(this)
  
  override def description = "A Cold Wave is in progress."
  override def toString = "Cold Wave"

}
