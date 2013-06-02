package eu.sunnyside.world.weather

import Humidity._

class Weather(change: DayToDayChange, tr: TemperatureRange, tf: Int, p: Precipitation, w: Wind, dh: DailyHumidity, oel: List[OngoingEffect]) {
  
  val ongoingEffects = oel
  
  val d2dc = change
  val temperatureRange = tr
  val temperatureFuzzy = tf
  val precipitation = p
  val wind = w
  val dailyHumidity = dh
  
  def hasSpecialWeather = ongoingEffects != null && (false /: ongoingEffects) { (result, effect) => result || effect.isSpecialWeather }

  def advanceEffectsOneDay: List[OngoingEffect] = ongoingEffects map { _.afterOneDay } filter { _ != null}
  
  def addEffect(e: Effect) = if (e == null) this else new Weather(change, tr, tf, p, w, dh, oel ::: List(OngoingEffect(e)))
  def addOngoingEffect(oe: OngoingEffect) = if (oe == null) this else new Weather(change, tr, tf, p, w, dh, oel ::: List(oe))
   
  def hasEffect(e: Effect) = ongoingEffects.find(_.effect == e) != None
  
  def findEffect(e: Effect) = {
    ongoingEffects.find(_.effect == e) match {
      case Some(oe: OngoingEffect) => oe
      case None => null
    }
  }
  
  def removeEffect(e: Effect) = {
    if (e == null) this 
    else {
      ongoingEffects.find(_.effect == e) match {
        case Some(oe: OngoingEffect) => new Weather(change, tr, tf, p, w, dh, oel.remove(_ == oe))
        case None => this
      }
    }
  }
  
  def applyTemperatureRangeChange(newTr: TemperatureRange) = new Weather(change, newTr, newTr.fuzzy, p, w, dh, oel)
  def applyTemperatureChange(newTr: TemperatureRange, newTf: Int) = new Weather(change, newTr, newTf, p, w, dh, oel)
  def applyWindChange(newWind: Wind) = new Weather(change, tr, tf, p, newWind, dh, oel)
  def applyPrecipitationChange(newPrec: Precipitation) = new Weather(change, tr, tf, newPrec, w, dh, oel)
  def applyHumidityChange(newDh: DailyHumidity) = new Weather(change, tr, tf, p, w, newDh, oel)
  
  def description = {
    {
      if (ongoingEffects.filter(_.effect.isVisible).isEmpty) ""
      else (ongoingEffects.filter(_.effect.isVisible).map(_.effect.description) mkString "\n") + "\n"
    } +
    temperatureRange.description +
    "\n" + wind.description + 
    "\n" + precipitation.description
  }
  
  override def toString = {
    {
      if (ongoingEffects.isEmpty) "" 
      else ("" /: ongoingEffects) { (result, oe) => result + oe.toString + "\n" }
    } +
    "High/Low: " + temperatureRange.from + "\u00B0F / " + temperatureRange.to + "\u00B0F"+
    "\nWind: " + (if (wind.intensity == 0) "None" else wind.toString) +
    "\nPrecipitation: " + precipitation.toString + "\n" +
    (ongoingEffects.filter(_.effect.isVisible).map(_.effect.description) mkString "\n")
  }
  
  def showEffects { ongoingEffects.foreach { println } }
  
}
