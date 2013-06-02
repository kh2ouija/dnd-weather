package eu.sunnyside.world.weather

import eu.sunnyside.world._
import Terrain._
import Climate._
import eu.sunnyside.world.weather._
import Season._
import eu.sunnyside.world.weather.tables.PrecipitationAmountTable

object PrecipitationAmount extends Enumeration {
  
  type PrecipitationAmount = Value
  
  val None = Value("None")
  val Trace = Value("Trace")
  val Light = Value("Light")
  val Moderate = Value("Moderate")
  val Heavy = Value("Heavy")
  val Downpour = Value("Downpour")
  val Torrential = Value("Torrential") // with Hurricane only
  
  def getMax(location: Location, season: Season): PrecipitationAmount = PrecipitationAmount(location, season, 1)
  def getMed(location: Location, season: Season): PrecipitationAmount = PrecipitationAmount(location, season, 2)
  def getMin(location: Location, season: Season): PrecipitationAmount = PrecipitationAmount(location, season, 0)  
  
  def apply(location: Location, season: Season, dice1: Int, dice2: Int): PrecipitationAmount = {
    val relativeLevel = {
      if (dice1 > dice2) 0
      else if (dice1 == dice2) 1
      else 2
    }    
    PrecipitationAmount(location, season, relativeLevel)
  }
  
  /**
   * 0 = the minimal for the context, 1 = maximum, 2 = medium! 
   */
  private def apply(location: Location, season: Season, relativeLevel: Int): PrecipitationAmount = {
    val (from, to) = season match {
      case Winter => (0, 3)
      case Spring => (3, 6)
      case Summer => (6, 9)
      case Autumn => (9, 12)
    }
    val codes = PrecipitationAmountTable.table(location.climate)(location.terrain).substring(from, to)
    forCode(codes(relativeLevel))
  }
  
  def forCode(c: Char) = c match {
    case '-' => None
    case 'T' => Trace
    case 'L' => Light
    case 'M' => Moderate
    case 'H' => Heavy
    case 'D' => Downpour
  }
  
  def increment(amount: PrecipitationAmount) = amount match {
    case None => Trace
    case Trace => Light
    case Light => Moderate
    case Moderate => Heavy
    case Heavy => Downpour
    case Downpour => Downpour
  }

}
