package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.weather.Effect
import eu.sunnyside.world.weather.InternalEffect

class EffectHasEnded(e: Effect) extends InternalEffect {
  
  val code = '-'
  val duration = 1
  val indefinite = false
  val priority = 0
  override val isVisible = true
  
  override def description = "The " + e.toString + " has ended."
  override def toString = "Effect has ended: " + e

}
