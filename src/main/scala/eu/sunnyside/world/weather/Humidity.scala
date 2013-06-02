package eu.sunnyside.world.weather

import eu.sunnyside.world._
import eu.sunnyside.world.weather.tables.HumidityTable
import Season._

abstract class Humidity extends Ordered[Humidity] {
  
  def level: Int
    
  def step(steps: Int, l: Location, s: Season) = {
    val default = Humidity(l, s)
    val min = default.level - 1
    val max = default.level + 1
    val reached = level + steps
    val newLevel = {
      if (reached > max) max
      else if (reached < min) min
      else reached
    }
    Humidity(newLevel)    
  }
  
   def compare(that: Humidity) = this.level - that.level
   
}


case object Dry extends Humidity {
  val level = 0
  override def toString = "Dry"
}
case object Low extends Humidity {
  val level = 1
  override def toString = "Low"
}
case object Medium extends Humidity {
  val level = 2
  override def toString = "Medium"
}
case object High extends Humidity {
  val level = 3
  override def toString = "High"
}
case object Saturated extends Humidity {
  val level = 4
  override def toString = "Saturated"
}
  
  
object Humidity {
  
  def apply(l: Location, s: Season): Humidity = {
    val index = s match {
      case Winter => 0
      case Spring => 1
      case Summer => 2
      case Autumn => 3
    }
    HumidityTable.table(l.climate)(l.terrain)(index)
  }
  
  def apply(level: Int): Humidity = level match {
    case 0 => Dry
    case 1 => Low
    case 2 => Medium
    case 3 => High
    case 4 => Saturated
  }
  
}
