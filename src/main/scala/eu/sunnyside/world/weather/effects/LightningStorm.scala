package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.weather._
import eu.sunnyside.world.Location
import eu.sunnyside.world.time._
import eu.sunnyside.world.tools._
import PrecipitationAmount._

class LightningStorm extends ExtremePrecipitation {

  val epcode = 'L'
  
  val minutes = 18 + 2 * Dice.roll(6) 
  
  override def influence(w: Weather, wp: Weather, l: Location, d: Date, dt: Int, dp: Int): Weather = {
    w.precipitation.amount match {
      case None | Light | Moderate => w.applyPrecipitationChange(Precipitation(None, w.temperatureFuzzy))
      case Heavy | Downpour => w
    }
  }
  
  override def description = "There is a Lightning Storm for " + minutes + " minutes."
  override def toString = "Lightning Storm"
  
}
