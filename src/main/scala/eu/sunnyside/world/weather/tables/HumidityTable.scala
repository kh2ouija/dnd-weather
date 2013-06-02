package eu.sunnyside.world.weather.tables

import eu.sunnyside.world.weather._
import eu.sunnyside.world.Terrain
import eu.sunnyside.world.Climate
import Climate._
import Terrain._
import Humidity._

object HumidityTable {
  
    val table = Map(
  
    Arctic -> Map(    
      Desert    -> Array(Low, Low, Low, Low) ,
      Hills     -> Array(Low, Low, Low, Low) ,
      Mountains -> Array(Low, Low, Low, Low) ,
      Plains    -> Array(Low, Low, Low, Low) ,
      Seacoast  -> Array(Low, Low, Low, Low) ,
      Swamp     -> Array(Low, Low, Low, Low)
    ),
    
    Subarctic -> Map(
      Desert    -> Array(Low, Low, Low, Low) ,
      Forest    -> Array(Low, Medium, Medium, Low) ,
      Hills     -> Array(Low, Low, Low, Low) ,
      Mountains -> Array(Low, Medium, Low, Low) ,
      Plains    -> Array(Low, Medium, Medium, Low) ,
      Seacoast  -> Array(Low, Medium, Medium, Low) ,
      Swamp     -> Array(Low, Medium, Medium, Low)
    ),
    
    Temperate -> Map(
      Desert    -> Array(Low, Low, Low, Low) ,
      Forest    -> Array(Medium, High, Medium, Medium) ,
      Hills     -> Array(Medium, High, High, Medium) ,
      Mountains -> Array(Low, Medium, Low, Medium) ,
      Plains    -> Array(Medium, High, High, Medium) ,
      Seacoast  -> Array(High, Medium, Medium, High) ,
      Swamp     -> Array(Medium, High, High, Medium)
    ),
    
    Subtropical -> Map(
      Desert    -> Array(Low, Low, Low, Low) ,
      Forest    -> Array(High, High, High, High) ,
      Hills     -> Array(Medium, High, High, High) ,
      Mountains -> Array(Medium, High, High, High) ,
      Plains    -> Array(Medium, High, Medium, Low) ,
      Seacoast  -> Array(Medium, High, High, Medium) ,
      Swamp     -> Array(Medium, High, High, Medium)
    ),
    
    Tropical -> Map(
      Desert    -> Array(Low, Low, Low, Low) ,
      Forest    -> Array(High, High, High, High) ,
      Hills     -> Array(Medium, Medium, High, Medium) ,
      Mountains -> Array(Medium, High, High, High) ,
      Plains    -> Array(Medium, High, High, High) ,
      Seacoast  -> Array(Medium, High, High, Medium) ,
      Swamp     -> Array(Medium, High, High, High)
    )
    
  )

}
