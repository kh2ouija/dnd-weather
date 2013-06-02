package eu.sunnyside.world.weather.tables

import eu.sunnyside.world.weather.DayToDayChange

object DayToDayChangeTable {
  
  def table(x: Any) = x match {
    
    case ( 2, d1: Int, d2: Int) => new DayToDayChange(-3, true ,   0, true,  d1, d2)
    case ( 3, d1: Int, d2: Int) => new DayToDayChange(-2, false,  15, false, d1, d2)
    case ( 4, d1: Int, d2: Int) => new DayToDayChange(-2, true ,  10, false, d1, d2)
    case ( 5, d1: Int, d2: Int) => new DayToDayChange(-1, false,  15, false, d1, d2)
    case ( 6, d1: Int, d2: Int) => new DayToDayChange(-1, true ,  10, false, d1, d2)
    case ( 7, d1: Int, d2: Int) => new DayToDayChange( 0, false,   0, false, d1, d2)
    case ( 8, d1: Int, d2: Int) => new DayToDayChange( 1, true , -10, false, d1, d2)
    case ( 9, d1: Int, d2: Int) => new DayToDayChange( 1, false, -15, false, d1, d2)
    case (10, d1: Int, d2: Int) => new DayToDayChange( 2, true , -10, false, d1, d2)
    case (11, d1: Int, d2: Int) => new DayToDayChange( 2, false, -15, false, d1, d2)
    case (12, d1: Int, d2: Int) => new DayToDayChange( 3, true ,   0, true,  d1, d2)
    
  }

}
