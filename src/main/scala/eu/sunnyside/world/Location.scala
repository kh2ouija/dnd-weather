package eu.sunnyside.world

import Hemisphere._
import Climate._
import Terrain._

/**
 * A location on the planet is defined by hemisphere, climate zone and terrain type
 */
class Location(h: Hemisphere, c: Climate, t: Terrain) {

  val hemisphere = h
  val climate = c
  val terrain = t
  
  override def toString = (climate match {
    case Arctic => "An "
    case _ => "A "
  }) + climate + " " + terrain + " in the " + hemisphere + " hemisphere."
  
}
