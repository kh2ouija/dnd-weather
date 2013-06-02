package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.time._
import eu.sunnyside.world.weather._
import eu.sunnyside.world.weather.effects._
import PrecipitationAmount._
import eu.sunnyside.world.Location

import eu.sunnyside.world.tools.Dice

object Drought extends SpecialWeather {

  val code = 'D'
  def duration = 2 + Dice.roll(6) + Dice.roll(6)
  val indefinite = false
  val priority = 10
  
  override def influence(w: Weather, wp: Weather, l: Location, d: Date, dt: Int, dp: Int): Weather = {
    // on the first day of a drought, no precipitation will fall
    if (dp == 0) w.applyPrecipitationChange(Precipitation(None, w.precipitation.form))
    else if (w.precipitation.amount == Trace) w.applyPrecipitationChange(Precipitation(None, w.precipitation.form))
    else {
      PrecipitationAmount.getMax(l, Season(d)) match {
        case None | Trace => {
          w.applyPrecipitationChange(Precipitation(None, w.precipitation.form))
        }          
        case Light | Moderate => {
          if (w.precipitation.amount == None) w
          else if (w.hasEffect(DroughtRainCooldown))  {
            w.applyPrecipitationChange(Precipitation(None, w.precipitation.form))
          }
          else {
            w.applyPrecipitationChange(Precipitation(Trace, w.precipitation.form)).addEffect(DroughtRainCooldown)
          }
        }
        case Heavy => {
          val amount = w.precipitation.amount match {
            case None | Trace | Light => None
            case Moderate => Trace
            case Heavy => Light
          }
          w.applyPrecipitationChange(Precipitation(amount, w.precipitation.form))
        }
      }     
    }
  }
  
  override def onExit = RemoveDroughtRainCooldown
   
  override def description = "A Drought is in progress."
  override def toString = "Drought"
  
}
