package eu.sunnyside.world.weather

import eu.sunnyside.world._
import eu.sunnyside.world.tools.Dice
import eu.sunnyside.world.weather._
import eu.sunnyside.world.time._
import Climate._
import Terrain._
import Season._
import PrecipitationAmount._
import PrecipitationForm._
import scala.collection.mutable

object Forecaster {
  
  def seed(location: Location, date: Date) = {
    val default = MonthlyTemperatureRanges(location.climate, location.terrain, date.month)
    new Weather(DayToDayChange.startingValue, default.med, default.med.fuzzy, Precipitation(None, default.med.fuzzy), Wind(location, Season(date), 0), DailyHumidity(location, Season(date)), Nil)
  }

  
  private def dayForecast(location: Location, date: Date, weatherPrev: Weather, weatherPrevPrev: Weather): Weather = {
    
    // DAY TO DAY CHANGE
    val d2dc = ForecasterHelper.calculateDayToDayChange(location, date, weatherPrev, weatherPrevPrev)
    
    // TEMPERATURE
    val temperatureRange = ForecasterHelper.calculateNormalTemperatureRange(location, date, d2dc, weatherPrev, weatherPrevPrev)
    val temperatureFuzzy = temperatureRange.fuzzy
       
    // EFFECTS
    val ongoingEffects = {
      val inherited = weatherPrev.advanceEffectsOneDay
      val effect = ForecasterHelper.calculateEffect(inherited, location, date, d2dc, temperatureFuzzy)
      
      if (effect == null || (effect.isSpecialWeather && (false /: inherited) { (result, effect) => result || effect.isSpecialWeather })) inherited
      else inherited ::: List(OngoingEffect(effect))      
    } 
    
    // PRECIPITATION
    val ongoingSpecialWeather = (false /: ongoingEffects) { (result, effect) => result || effect.isSpecialWeather }
    val precipitation = ForecasterHelper.calculateNormalPrecipitation(location, date, d2dc, temperatureFuzzy, weatherPrev, ongoingSpecialWeather)    
    
    // WIND
    val wind = ForecasterHelper.calculateNormalWind(location, Season(date), d2dc, weatherPrev)
    
    // HUMIDITY
    val humidity = Humidity(location, Season(date))
    var dh = DailyHumidity(humidity, humidity)
       
    // WEATHER
    val weatherNormal = new Weather(d2dc, temperatureRange, temperatureFuzzy, precipitation, wind, dh, ongoingEffects)
        
    val weather = (weatherNormal /: weatherNormal.ongoingEffects.sort((o1, o2) => o1.effect.priority > o2.effect.priority)) { (w, o) => { o.influence(w, weatherPrev, location, date) } }

    weather
  }
  
    
  def forecastFromScratch(location: Location, startDate: Date, days: Int) = {
    val array = new Array[Weather](days)
    
    // FIRST PASS    
    array(0) = seed(location, startDate)
    array(1) = dayForecast(location, startDate.addDays(1), array(0), null)
    for (i <- 2 until days) {
      val now = startDate.addDays(i)
      array(i) = dayForecast(location, now, array(i - 1), array(i - 2))
    }
    
    // SECOND PASS
    ForecasterHelper.humidityPass(location, startDate, array);
    
    Forecast(location, startDate, array)
  }
  
}
