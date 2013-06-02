package eu.sunnyside.world.weather

import eu.sunnyside.world._
import Direction._
import eu.sunnyside.world.tools._
import Climate._
import Hemisphere._
import Season._


class Wind(d: Direction, max: Int) {
  
  val direction = d
  val intensity = max 
  
  def description = "Wind: " + (if (intensity == 0) "None" else toString)
  override def toString = direction + " " + intensity + "mph"

}

object Wind {
  
  def apply(location: Location, season: Season, max: Int): Wind = {
    val direction = location.climate match {
      case Arctic => E
      case Subarctic => season match {
        case Autumn | Winter => location.hemisphere match {
          case Northern => if (Dice.flipCoin) NW else N
          case Southern => if (Dice.flipCoin) SW else S
        }
        case Spring | Summer => location.hemisphere match {
          case Northern => if (Dice.flipCoin) SW else S
          case Southern => if (Dice.flipCoin) NW else N
        }
      }
      case Temperate => {
        val roll = Dice.roll(6) 
        if (roll <= 2) N
        else if (roll <= 4) W
        else S
      }
      case Subtropical => location.hemisphere match {
        case Northern => if (Dice.flipCoin) NE else E
        case Southern => if (Dice.flipCoin) SE else E
      }
      case Tropical => location.hemisphere match {
        case Northern => NE
        case Southern => SE
      }      
    }
    new Wind(direction, max)
  }
  
}
