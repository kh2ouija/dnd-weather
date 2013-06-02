package eu.sunnyside.world.weather
import eu.sunnyside.world.Location
import eu.sunnyside.world.time.Date

class Forecast(l: Location, dwArr: Array[(Date, Weather)]) {

  val location = l
  val data = dwArr
  val startDate = dwArr(0)._1
  val endDate = dwArr(dwArr.size - 1)._1
  
  def getData = data
  
  def getWeather(date: Date) {
    if (date >= startDate && date <= endDate) data(date.dayAbsolute - startDate.dayAbsolute)
    else null
  }
  
}

object Forecast {

  def apply(l: Location, sd: Date, wArr: Array[Weather]) = {
    val dwArr = new Array[(Date, Weather)](wArr.size)
    for (i <- 0 until wArr.size) dwArr(i) = (sd.addDays(i), wArr(i))
    new Forecast(l, dwArr)
  }
  
}