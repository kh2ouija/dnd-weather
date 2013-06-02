package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.weather._
import eu.sunnyside.world._
import eu.sunnyside.world.tools._
import eu.sunnyside.world.time._
import Climate._
import Terrain._
import PrecipitationAmount._ 

object Gale extends SpecialWeather {

  val code = 'G'
  def duration = 1 //
  val indefinite = false
  val priority = 10
  
  override def influence(w: Weather, wp: Weather, l: Location, d: Date, daysTotal: Int, daysPassed: Int): Weather = {
    val wind = Wind(l, Season(d), 40 + 5 * Dice.roll(6))
    
    val (storm: Effect, precipitation: Precipitation) = { 
      if (l.terrain == Desert) {
        (ParticleStorm.severe(l), Precipitation(None, PrecipitationForm.forTemperature(w.temperatureFuzzy)))
      }
      else if  (l.climate == Arctic || l.climate == Subarctic) {
        (ParticleStorm.severe(l), Precipitation.seed(l, Season(d), w.temperatureFuzzy))      
      }
      else {
        (null,  Precipitation.seed(l, Season(d), w.temperatureFuzzy))      
      }
    }
    w.applyWindChange(wind).addEffect(storm).applyPrecipitationChange(precipitation)
  }
  
  override def description = "Gale winds blow throughout the day."
  override def toString = "Gale"
  
}
