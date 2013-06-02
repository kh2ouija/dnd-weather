package eu.sunnyside.world.weather

import eu.sunnyside.world.weather.tables.DayToDayChangeTable

class DayToDayChange(tsteps: Int, pp: Boolean, wmod: Int, ep: Boolean, d1: Int, d2: Int) {
  
  val dice1 = d1
  val dice2 = d2
  val roll = dice1 + dice2
  val temperatureSteps = tsteps
  val precipitationPossible = pp
  val windModifier = wmod
  val doubleRoll = (d1 == d2)
  val effectPossible = ep
  
  override def toString = "temp " + temperatureSteps + ", wind " + windModifier

}

object DayToDayChange {
  
  def startingValue: DayToDayChange = new DayToDayChange(0, false, 0, false, 1, 2)
  def apply(roll: Int, dice1: Int, dice2: Int) = DayToDayChangeTable.table(roll, dice1, dice2) 
  
}
