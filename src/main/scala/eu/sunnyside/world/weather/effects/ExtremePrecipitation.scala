package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.weather._
import eu.sunnyside.world.Climate._
import eu.sunnyside.world.tools.Dice

abstract class ExtremePrecipitation extends SpecialWeather {

  val code = 'X'
  def duration = 1 //
  val indefinite = false
  val priority = 10
  def epcode: Char
  
}

object ExtremePrecipitation {
  
  def apply(existingOngoingEffects: List[OngoingEffect], climate: Climate, temperature: Int): ExtremePrecipitation = {
    val tstClimate = (climate == Tropical || climate == Subtropical)
    val roll = Dice.roll(6)
    
    if (temperature <= -1) {
      if (tstClimate) null
      else {
        if (roll <= 3) SevereSnowstorm
        else null
      }
    }
    else if (temperature <= 9) {
      if (tstClimate) null
      else {
        if (roll <= 5) SevereSnowstorm
        else null
      }
    }
    else if (temperature <= 29) {
      if (tstClimate) null
      else {
        if (roll <= 5) SevereSnowstorm
        else {
          if (temperature >= 25) IceStorm
          else null
        }
      }
    }
    else if (temperature <= 35) {
      if (tstClimate) new Hailstorm
      else {
        if (roll <= 4) SevereSnowstorm
        else if (roll == 5) new Hailstorm
        else IceStorm
      }
    }
    else if (temperature <= 49) {
      if (tstClimate) {
        if (roll <= 5) new LightningStorm
        else new Hailstorm
      }
      else {
        if (roll <= 4) new LightningStorm
        else new Hailstorm
      }
    }
    else if (temperature <= 74) {
      if (tstClimate) new LightningStorm
      else {
        if (roll <= 5) new LightningStorm
        else new Hailstorm
      }
    }
    else new LightningStorm
  }
  
}
