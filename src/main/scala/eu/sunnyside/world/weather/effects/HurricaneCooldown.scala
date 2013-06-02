package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.weather.InternalEffect
import eu.sunnyside.world.time._
import Constants._

object HurricaneCooldown extends InternalEffect {
  
  val code = '-'
  def duration = DAYS_PER_MONTH
  val indefinite = false
  val priority = 0
    
  override def toString = "Hurricane Cooldown"

}
