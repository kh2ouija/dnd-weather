package eu.sunnyside.world.weather.effects

import eu.sunnyside.world._
import eu.sunnyside.world.time.Date
import eu.sunnyside.world.weather._
import Climate._
import Terrain._

object VerySlightWind extends SpecialWeather {
  
  val code = '-'
  def duration = 1 //  
  val indefinite = false
  val priority = 10
  override def isVisible = false
  
  
  override def influence(w: Weather, wp: Weather, l: Location, d: Date, dt: Int, dp: Int) = {
    
    // wind occasionally gusts up to 5 mph
    val wind = Wind(l, Season(d), 5)
    
    // sharp increase in temperature
    val temperature = {
      val maxMonth = MonthlyTemperatureRanges(l.climate, l.terrain, d.month).max
      
      if (wp.temperatureRange.code <= 'W') {
        val raised = wp.temperatureRange.step(3)
        if (raised.code > maxMonth.code) maxMonth
        else raised
      }
      else maxMonth
    }
    
    // change of normal precipitation
    val precipitationAmount = PrecipitationAmount.getMax(l, Season(d))
    val precipitationForm = PrecipitationForm.forTemperature(w.temperatureFuzzy)
    val precipitation = new Precipitation(precipitationAmount, precipitationForm)
    
    w.applyTemperatureRangeChange(temperature).applyWindChange(wind).applyPrecipitationChange(precipitation)
    
  }
  
  override def toString = "Very Slight Wind"

}