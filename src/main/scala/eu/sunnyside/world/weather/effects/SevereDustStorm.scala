package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.tools._

class SevereDustStorm extends ParticleStorm {
  
  val hours = 1 + Dice.roll(6)
  
  override def description = "The strong winds cause a Severe Dust Storm which lasts for " + hours + " hours."
  override def toString = "Severe Dust Storm"

}
