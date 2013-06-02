package eu.sunnyside.world.weather

import eu.sunnyside.world._
import PrecipitationAmount._
import PrecipitationForm._
import Climate._
import Season._

class Precipitation(a: PrecipitationAmount, f: PrecipitationForm) {

  val amount = a
  val form = f
  
  def description = "Precipitation: " + toString
  
  override def toString = amount match {
      case None => "None"
      case Trace => "A Trace of " + form.toString
      case Light => "Light " + form.toString
      case Moderate => "Moderate " + form.toString
      case Heavy => "Heavy " + form.toString
      case Downpour => "Downpour " + form.toString 
      case Torrential => "Torrential " + form.toString
  }
  
}

object Precipitation {
  
  def apply(a: PrecipitationAmount, tf: Int): Precipitation = Precipitation(a, PrecipitationForm.forTemperature(tf))
  def apply(a: PrecipitationAmount, f: PrecipitationForm): Precipitation = new Precipitation(a, f)
  
  def seed(l: Location, s: Season, tf: Int) = Precipitation(PrecipitationAmount.getMed(l, s), PrecipitationForm.forTemperature(tf))
  
}
