package eu.sunnyside.world.weather

import eu.sunnyside.world.time.Date

object Season extends Enumeration {
  
  type Season = Value
  
  val Winter = Value("Winter")
  val Spring = Value("Spring")
  val Summer = Value("Summer")
  val Autumn = Value("Autumn")
  
  /**
   * Get the Season for a Date
   */
  def apply(date: Date) = {
    if (date.month <=3) Winter
    else if (date.month <= 6) Spring
    else if (date.month <= 9) Summer
    else Autumn
  }

}
