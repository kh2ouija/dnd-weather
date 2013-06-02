package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.weather.SpecialWeather
import eu.sunnyside.world.tools._
import eu.sunnyside.world._
import Terrain._

abstract class Fog extends SpecialWeather {

  val code = 'M'
  def duration = 1 //
  val indefinite = false
  val priority = 10
  
  val roll = Dice.roll(6)
  val when = {
    if (roll <= 4) "sunrise"
    else "sunset"
  }
  val hours = roll
  
  override def toString = "Fog"
  
}

object Fog {
  
  def apply(l: Location) = {
    if (l.terrain == Seacoast) new HeavyFog
    else new ModerateFog
  }
  
}
