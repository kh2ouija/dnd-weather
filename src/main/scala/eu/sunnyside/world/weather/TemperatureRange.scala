package eu.sunnyside.world.weather

import eu.sunnyside.world.tools.Dice
import eu.sunnyside.world._
import Terrain._
import Climate._
import eu.sunnyside.world.weather.tables.TemperatureRangeCodesTable

class TemperatureRange(c: Char, min: Int, max: Int) {
  
  val code = c
  val from = min
  val to = max
  
  def step(steps: Int) = {
    val reached = (code + steps).asInstanceOf[Char]
    val newcode = {
      if (reached < '@') '@'
      else if (reached > '[') '['
      else reached
    }
    TemperatureRange(newcode)
  }
  
  def fuzzy = min + ((0 /: (1 to (max - min))) { (result, i) => result + (if (Dice.flipCoin) 1 else 0) } )  
  
  def description = "Temperature: " + fuzzy + "\u00B0F" + "\nHigh/Low: " + from + "\u00B0F / " + to + "\u00B0F"
  override def toString = "(" + code + ") " + from + " - " + to
  
}

object TemperatureRange {
  
  /**
   * Get the TemperatureRange represented by a Code (char)
   */
  def apply(code: Char) = TemperatureRangeCodesTable.table(code)
  
}
