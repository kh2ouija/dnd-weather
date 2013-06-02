package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.tools._

class SevereBlowingSnow extends ParticleStorm {
  
  val hours = 1 + Dice.roll(6)
  
  override def description = "The strong winds cause Severe Blowing Snow for " + hours + " hours."
  override def toString = "Severe Blowing Snow"

}
