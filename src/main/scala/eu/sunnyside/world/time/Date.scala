package eu.sunnyside.world.time

import Constants._

/**
 * A date is internally defined by the number of days since the beginning of the world
 * The normal usage form is (dayOfMonth, month, year)
 */
class Date(abs: Int) extends Ordered[Date] {

  val dayAbsolute = abs  
  val year = ((dayAbsolute - 1) / DAYS_PER_YEAR) + 1
  val dayOfYear = dayAbsolute - ((year - 1) * DAYS_PER_YEAR)
  val month = (dayOfYear - 1) / DAYS_PER_MONTH + 1
  val dayOfMonth = dayOfYear - ((month - 1) * DAYS_PER_MONTH)
  
  def addDays(days: Int) = new Date(dayAbsolute + days)
  def prev = addDays(-1)  
  
  def compare(that: Date) = this.dayAbsolute - that.dayAbsolute
  
  override def hashCode = dayAbsolute.hashCode
  
  override def equals(that: Any) = that match {
    case that: Date => this.dayAbsolute == that.dayAbsolute
    case _ => false
  }
  
  //override def toString = (if (dayOfMonth < 10) "0" else "") + dayOfMonth + "-" + (if (month < 10) "0" else "") + month + "-" + year   
  override def toString = "Day " + dayOfMonth + ", Month " + month + ", Year " + year
  
}

object Date {
  
  def apply(year: Int, month: Int, dayOfMonth: Int) = new Date( (year - 1) * DAYS_PER_YEAR + (month - 1) * DAYS_PER_MONTH + dayOfMonth )
  
}
