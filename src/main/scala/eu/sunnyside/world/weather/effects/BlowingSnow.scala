package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.tools._

class BlowingSnow extends ParticleStorm {
  
  val hours = 1 + Dice.roll(4)
  
  override def description = "There is a Blizzard for " + hours + " hours."
  override def toString = "Blowing Snow"

}
