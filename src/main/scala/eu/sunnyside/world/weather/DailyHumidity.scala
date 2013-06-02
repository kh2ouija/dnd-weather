package eu.sunnyside.world.weather

import eu.sunnyside.world.Location
import Season._

class DailyHumidity(h1: Humidity, h2: Humidity) {
  
  val beforePrecipitation = h1
  val afterPrecipitation = h2
  
  override def toString = "Daily Humidity: " + h1 + "/" + h2

}

object DailyHumidity {
  
  def apply(l: Location, s: Season): DailyHumidity = {
    val humidity = Humidity(l, s)
    DailyHumidity(humidity, humidity)
  }
  def apply(h1: Humidity, h2: Humidity): DailyHumidity = new DailyHumidity(h1, h2)
  
}