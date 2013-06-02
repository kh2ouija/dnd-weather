package eu.sunnyside.world.weather.effects

import eu.sunnyside.world._
import eu.sunnyside.world.time.Date
import eu.sunnyside.world.weather._
import Climate._
import Terrain._

object VeryStrongWind extends SpecialWeather {
  
  val code = '-'
  def duration = 1 //
  val indefinite = false
  val priority = 10
  override def isVisible = false
  
  override def influence(w: Weather, wp: Weather, l: Location, d: Date, dt: Int, dp: Int) = {
    
    // wind gusts up to 45 mph
    val wind = Wind(l, Season(d), 45)
    
    // sharp decrease in temperature
    val temperature = {
      val minMonth = MonthlyTemperatureRanges(l.climate, l.terrain, d.month).min
      
      if (wp.temperatureRange.code >= 'D') {
        val lowered = wp.temperatureRange.step(-3)
        if (lowered.code < minMonth.code) minMonth
        else lowered
      }
      else minMonth
    }
    
    // change of normal precipitation
    val precipitation = Precipitation.seed(l, Season(d), w.temperatureFuzzy)
        
    w.applyTemperatureRangeChange(temperature).applyWindChange(wind).applyPrecipitationChange(precipitation)
    
  }
  
  override def toString = "Very Strong Wind"

}
