package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.weather.InternalEffect
/**
 * Rains in <=M regions can occur during drought at most once every five days
 */
object DroughtRainCooldown extends InternalEffect {
  
  val code = '-'
  val duration = 5
  val indefinite = false
  val priority = 0
  
  override def toString = "Drought Rain Cooldown"

}
