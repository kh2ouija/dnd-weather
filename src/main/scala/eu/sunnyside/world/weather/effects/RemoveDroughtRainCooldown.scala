package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.Location
import eu.sunnyside.world.time._
import eu.sunnyside.world.weather._
import eu.sunnyside.world.weather.effects._

/**
 * Remove if existing DroughtRainCooldown from effects stack
 */
object RemoveDroughtRainCooldown extends InternalEffect {
  
  val code = '-'
  val priority = 20
  val indefinite = false
  val duration = 1
  
  override def influence(w: Weather, wp: Weather, l: Location, d: Date, daysTotal: Int, daysPassed: Int): Weather = {
    w.removeEffect(DroughtRainCooldown)
  }
  
  override def toString = "Reset Drought Rain Cooldown"

}
