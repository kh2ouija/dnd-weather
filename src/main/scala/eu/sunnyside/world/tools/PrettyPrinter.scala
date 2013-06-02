package eu.sunnyside.world.tools

import eu.sunnyside.world.time._
import Constants._
import eu.sunnyside.world.weather._
import UnitSystem._
import PrecipitationAmount._

class PrettyPrinter(us: UnitSystem) {
  
  val c = ImperialSystemConvertor(us)
  
  def print(d: Date, w: Weather): List[String] = {
    Nil ::: printDate(d) ::: printWeather(w)
  }
  
  def printDate(d: Date): List[String] = {
    val date = d.toString
    val season = {
      if (d.month <= 3) {
        if (d.month == 1 && d.dayOfMonth == 1) "It is the first day of Winter."
        else if (d.month == 3 && d.dayOfMonth == DAYS_PER_MONTH) "It is the last day of Winter."
        else "It is Winter."
      }
      else if (d.month <= 6) {
        if (d.month == 4 && d.dayOfMonth == 1) "It is the first day of Spring"
        else if (d.month == 6 && d.dayOfMonth == DAYS_PER_MONTH) "It is the last day of Spring."
        else "It is Spring."
      }
      else if (d.month <= 9) {
        if (d.month == 7 && d.dayOfMonth == 1) "It is the first day of Summer"
        else if (d.month == 9 && d.dayOfMonth == DAYS_PER_MONTH) "It is the last day of Summer."
        else "It is Summer."
      }
      else {
        if (d.month == 10 && d.dayOfMonth == 1) "It is the first day of Autumn"
        else if (d.month == 12 && d.dayOfMonth == DAYS_PER_MONTH) "It is the last day of Autumn."
        else "It is Autumn."
      }
    }
    Nil ::: List(date) ::: List(season)
  }
  
  def printWeather(w: Weather): List[String] = {
    val temperatureFuzzy = "The average temperature is " + c.convertF(w.temperatureFuzzy) + "."
    val temperatureRange = "The temperature varies from " + c.convertF(w.temperatureRange.from) + " at night to " + c.convertF(w.temperatureRange.to) + " during the day."
    val wind = (if (w.wind.intensity == 0) "There is no wind." else ("The wind blows from " + w.wind.direction + " with " + c.convertMph(w.wind.intensity) + "."))
    val precipitation = {
      if (w.precipitation.amount == None) "No precipitation falls."
      else w.precipitation.toString + " falls."
    }
    val humidity = {
      val before = w.dailyHumidity.beforePrecipitation
      val after = w.dailyHumidity.afterPrecipitation 
      if (before < after) {
        if (before == Dry) {
          "The air is " + before + " but humidity raises to " + after + " after the " + w.precipitation.form + "."
        }
        else {
          "Humidity is " + before + " and raises to " + after + " after the " + w.precipitation.form + "."
        }
      }
      else if (before == after) {
        if (before == Dry) {
          "The air is " + before + "."
        }
        else {
          "Humidity is " + before + "."
        }
      }
      else {
        if (after == Dry) {
          "Humidity is " + before + " but the air becomes " + after + " after the " + w.precipitation.form + "."
        }
        else {
          "Humidity is " + before + " and drops to " + after + " after the " + w.precipitation.form + "."
        }
      }      
    }
    val effectsList: List[String] = {
      if (w.ongoingEffects.filter(_.effect.isVisible).isEmpty) Nil
      else (w.ongoingEffects.filter(_.effect.isVisible).map(_.effect.description))
    }
    
    Nil ::: effectsList ::: List(temperatureRange) ::: List(temperatureFuzzy) ::: List(wind) ::: List(precipitation) ::: List(humidity)
  }
  
  
  def toXML(f: Forecast): xml.Elem = {
    <forecast>
    {
  	  for { (d: Date, w: Weather) <- f.data } yield
  	    <date>
  	  	  <year>{d.year}</year>
          <month>{d.month}</month>
          <dayOfMonth>{d.dayOfMonth}</dayOfMonth>
        
          <temperature>
            <min>{c.convertF(w.temperatureRange.from)}</min>
            <max>{c.convertF(w.temperatureRange.to)}</max>
            <fuzzy>{c.convertF(w.temperatureFuzzy)}</fuzzy>
          </temperature>
          <humidity>
            <before>{w.dailyHumidity.beforePrecipitation}</before>
            <after>{w.dailyHumidity.afterPrecipitation}</after>
          </humidity>
          <wind>
            <direction>{w.wind.direction}</direction>
            <intensity>{c.convertMph(w.wind.intensity)}</intensity>
          </wind>
          <precipitation>
            <form>{w.precipitation.form}</form>
            <amount>{w.precipitation.amount}</amount>
         </precipitation>
         <effects>
         {
           for { e <- w.ongoingEffects.filter(_.effect.isVisible) } yield
             <effect>
               <name>{e.effect.toString}</name>
             </effect>          
         }
         </effects>
       </date>
       
    }
    </forecast>
  }
  
}

object PrettyPrinter {
  
  def apply(us: UnitSystem) = new PrettyPrinter(us)
  
}
