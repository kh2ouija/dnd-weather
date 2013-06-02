package eu.sunnyside.world.weather

import eu.sunnyside.world.tools.Dice

object PrecipitationForm extends Enumeration {
  
  type PrecipitationForm = Value
  
  val Rain = Value("Rain")
  val Sleet = Value("Sleet")
  val Snow = Value("Snow")
  
  def forTemperature(t: Int): PrecipitationForm = {
    if (t >= 36) Rain
    else if (t >= 30) {
      if (Dice.flipCoin) Sleet
      else Snow
    }
    else Snow
  }

}
