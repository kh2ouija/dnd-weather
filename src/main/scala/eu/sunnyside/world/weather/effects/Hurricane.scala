package eu.sunnyside.world.weather.effects

import eu.sunnyside.world._
import eu.sunnyside.world.tools._
import eu.sunnyside.world.time._
import eu.sunnyside.world.weather._
import PrecipitationAmount._

object Hurricane extends SpecialWeather {

  val code = 'C'
  def duration = 3
  val indefinite = false
  val priority = 10
  
  override def influence(w: Weather, wp: Weather, l: Location, d: Date, daysTotal: Int, daysPassed: Int): Weather = {
    if (daysPassed == 0) {
      val wind = Wind(l, Season(d), 60 + 20 * Dice.roll(6))
      val precipitation = Precipitation(Torrential, w.temperatureFuzzy)
      w.applyWindChange(wind).applyPrecipitationChange(precipitation).addEffect(new HurricaneInitialTemperatureRange(w.temperatureRange))
    }
    else {
      val temperatureRange = {
        val roll = Dice.roll(6) + Dice.roll(6)
        val day1TemperatureRange = {
          w.ongoingEffects.find (_.effect.isInstanceOf[HurricaneInitialTemperatureRange]) match {
            case scala.Some(oe: OngoingEffect) => oe.effect.asInstanceOf[HurricaneInitialTemperatureRange].day1Temperature
            case scala.None => wp.temperatureRange
          }
        }
        if (roll <= 6) day1TemperatureRange.step(-1)
        else if (roll == 7) day1TemperatureRange
        else day1TemperatureRange.step(1)
      }
      val temperatureFuzzy = temperatureRange.fuzzy
      val precipitation = Precipitation(None, PrecipitationForm.forTemperature(temperatureFuzzy))
      val wind = Wind(l, Season(d), Math.min(10, w.wind.intensity))
      
      w.applyTemperatureChange(temperatureRange, temperatureFuzzy).applyPrecipitationChange(precipitation).applyWindChange(wind)      
    }
    
  }
  
  override def onDayBefore = new PreHurricaneLightningStorm
  override def onExit = HurricaneCooldown
  
  override def description = "A Hurricane passes through the region."
  override def toString = "Hurricane"
  
}
