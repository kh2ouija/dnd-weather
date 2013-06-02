package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.weather._

class HurricaneInitialTemperatureRange(tr: TemperatureRange) extends InternalEffect {
  
  val code = '-'
  val duration = 3
  val indefinite = false
  val priority = 0
  
  val day1Temperature = tr
  
  override def toString = "Hurricane Initial Temperature Range (" + day1Temperature.code + ")" 

}
