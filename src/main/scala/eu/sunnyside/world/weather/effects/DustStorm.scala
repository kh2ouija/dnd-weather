package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.tools._

class DustStorm extends ParticleStorm {
  
  val hours = 1 + Dice.roll(4)
  
  override def description = "There is a Dust Storm for " + hours + " hours."
  override def toString = "DustStorm"

}
