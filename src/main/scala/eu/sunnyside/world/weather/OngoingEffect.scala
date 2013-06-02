package eu.sunnyside.world.weather

import eu.sunnyside.world._
import eu.sunnyside.world.time._

class OngoingEffect(e: Effect, dur: Int, dp: Int) {
  val effect = e
  val duration = dur
  val daysPassed = dp
  val daysLeft = dur - dp  
  
  def afterOneDay = {
    if (!e.indefinite && daysLeft == 1) OngoingEffect(e.onExit)
    else new OngoingEffect(e, duration, dp + 1)
  }
  
  def isSpecialWeather = effect != null & effect.isSpecialWeather
  
  def influence(w: Weather, wp: Weather, l: Location, d: Date): Weather = {
    // double check that it is still active because some other effect may have removed this
    if (w.hasEffect(effect)) effect.influence(w, wp, l, d, duration, daysPassed)
    else w
  }
  
  override def toString = e.toString + ", day " + (dp + 1) + "/" + dur
}

object OngoingEffect {
  def apply(e: Effect) = {
    if (e == null) null
    else new OngoingEffect(e, e.duration, 0)
  }
}
