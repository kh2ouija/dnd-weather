package eu.sunnyside.world.tools

import UnitSystem._

trait ImperialSystemConvertor {
  
  def convertF(f: Int): String
  def convertMph(mph: Int): String
  def convertYd(yd: Int): String

}

object ImperialSystemConvertor {
  
  def apply(us: UnitSystem): ImperialSystemConvertor = us match {
    case Metric => ImperialToMetric
    case Imperial => ImperialToImperial
  }
  
}
