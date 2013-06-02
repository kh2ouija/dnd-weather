package eu.sunnyside.world.weather

import eu.sunnyside.world._
import Terrain._
import Climate._
import eu.sunnyside.world.weather.tables.MonthlyTemperatureRangesTable

class MonthlyTemperatureRanges(l: TemperatureRange, m: TemperatureRange, h: TemperatureRange) {

  val min = l
  val med = m
  val max = h
  
  override def toString = "[min: " + min + ", med: " + med + ", max: " + max + "]"
  
}

object MonthlyTemperatureRanges {
  
  /**
   * Get the TemperatureRange for a specific Climate, Terrain and Month (starting from 1)
   */ 
  def apply(climate: Climate, terrain: Terrain, month: Int): MonthlyTemperatureRanges = {
    val codes = MonthlyTemperatureRangesTable.table(climate)(terrain).substring((month - 1) * 3, month * 3)
    val l = TemperatureRange(codes(0))
    val m = TemperatureRange(codes(1))
    val h = TemperatureRange(codes(2))
    new MonthlyTemperatureRanges(l, m, h)
  }
  
  
}
