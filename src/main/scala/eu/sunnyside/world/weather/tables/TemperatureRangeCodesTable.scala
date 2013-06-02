package eu.sunnyside.world.weather.tables

import eu.sunnyside.world.weather.TemperatureRange

object TemperatureRangeCodesTable {
  
  val table = Map(    
    
    '@' -> new TemperatureRange('@', -50, -30), // can only appear during a Cold Wave and lasts for a maximum of 3 days total
    'A' -> new TemperatureRange('A', -40, -20),
    'B' -> new TemperatureRange('B', -30, -15),
    'C' -> new TemperatureRange('C', -20,  -5),
    'D' -> new TemperatureRange('D', -10,   0),
    'E' -> new TemperatureRange('E',   0,  10),
    'F' -> new TemperatureRange('F',  10,  18),
    'G' -> new TemperatureRange('G',  10,  25),
    'H' -> new TemperatureRange('H',  15,  30),
    'I' -> new TemperatureRange('I',  15,  35),
    'J' -> new TemperatureRange('J',  20,  40),
    'K' -> new TemperatureRange('K',  30,  50),
    'L' -> new TemperatureRange('L',  40,  60),
    'M' -> new TemperatureRange('M',  45,  65),
    'N' -> new TemperatureRange('N',  50,  70),
    'O' -> new TemperatureRange('O',  55,  70),
    'P' -> new TemperatureRange('P',  55,  75),
    'Q' -> new TemperatureRange('Q',  60,  80),
    'R' -> new TemperatureRange('R',  65,  80),
    'S' -> new TemperatureRange('S',  65,  85),
    'T' -> new TemperatureRange('T',  70,  85),
    'U' -> new TemperatureRange('U',  70,  90),
    'V' -> new TemperatureRange('V',  75,  90),
    'W' -> new TemperatureRange('W',  75,  95),
    'X' -> new TemperatureRange('X',  80, 100),
    'Y' -> new TemperatureRange('Y',  80, 105),
    'Z' -> new TemperatureRange('Z',  85, 115),
    '[' -> new TemperatureRange('[',  95, 125) // can only appear during a Heat Wave and lasts for a maximum of 3 days total
    
  )

}
