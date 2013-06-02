package eu.sunnyside.world.tools

object ImperialToMetric extends ImperialSystemConvertor {
  
  override def convertF(f: Int) = f2c(f) + "\u00B0C"
  override def convertMph(mph: Int) = mph2kmh(mph) + "km/h"
  override def convertYd(yd: Int) = yd2m(yd) + "m"
  
  def f2c(f: Int) = ((f - 32) * 5.0 /9).toInt
  def mph2kmh(mph: Int) = (mph * 1.609344).toInt
  def yd2m(yd: Int) = (yd * 0.9144).toInt
  
}
