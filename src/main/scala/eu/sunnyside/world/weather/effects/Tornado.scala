package eu.sunnyside.world.weather.effects

import eu.sunnyside.world._
import eu.sunnyside.world.time._
import eu.sunnyside.world.tools._
import eu.sunnyside.world.weather._

object Tornado extends SpecialWeather {

  val code = 'T'
  def duration = 1 //
  val indefinite = false
  val priority = 10
  
    
  override def description = "A Tornado passes through the region."
  override def toString = "Tornado"
  
}
