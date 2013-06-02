package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.tools._

class Hailstorm extends ExtremePrecipitation {
  
  val epcode = 'H'
  
  val minutes = 4 + Dice.roll(6) 
    
  override def description = "There is a Hailstorm for " + minutes + " minutes."
  override def toString = "Hailstorm"
  
}
