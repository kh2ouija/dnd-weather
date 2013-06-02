package eu.sunnyside.world.weather.tables

import eu.sunnyside.world._
import Climate._
import Terrain._

object EffectsTable {
  
  val table = Map(
  
    Arctic -> Map(    
      Desert    -> "GADDGADDGADDGADD" ,
      Hills     -> "GADDGADMGADZGADD" ,
      Mountains -> "GADDGADMGAMZGADM" ,
      Plains    -> "GADDAGDMXADZGADZ" ,
      Seacoast  -> "GADDAGMZGAMZGAMZ"      
    ),
    
    Subarctic -> Map(
      Desert    -> "GADDGADDASDDGADD" ,
      Forest    -> "GADZAXDZXAZDAXMD" ,
      Hills     -> "GAMDAGDZAXZDGAMD" ,
      Mountains -> "GADMAXMZAXZDGAMD" ,
      Plains    -> "GAMDAXDZZAZDGADZ" ,
      Seacoast  -> "GAMZGAMZXAZMAGMZ" ,
      Swamp     -> "AXMZAXMZXAZMAXMZ"
    ),
    
    Temperate -> Map(
      Desert    -> "ASDZGSDZGSDZSGDZ" ,
      Forest    -> "AXMZGXMZGXMZAXMZ" ,
      Hills     -> "AXMZAXZTAXDZAXDZ" ,
      Mountains -> "AXMDAXMZAXDZXADZ" ,
      Plains    -> "AGDZAXTZXGDZXADZ" ,
      Seacoast  -> "AXMZCXMZCXMZAXMZ" ,
      Swamp     -> "AXMZGXMZGXMZAXMZ"
    ),
    
    Subtropical -> Map(
      Desert    -> "ASDZGSDZGSDZGSDZ" ,
      Forest    -> "XAMZXGZMXXZMAXMZ" ,
      Hills     -> "AXDZAXDTXGDZAXZM" ,
      Mountains -> "AXDZAXZMXGZDXAZM" ,
      Plains    -> "AXDZXGZTXGDZGADZ" ,
      Seacoast  -> "AXDZCXMZCXMZMXDZ" ,
      Swamp     -> "AXDZCXMZCXMZCXDZ"
    ),
    
    Tropical -> Map(
      Desert    -> "ASDZGSDZGSDZGSDZ" ,
      Forest    -> "XXMZXXZMXXZMXXMZ" ,
      Hills     -> "AGDZGXDZGXDZGGZD" ,
      Mountains -> "AXMZAXMZXGZMAGMZ" ,
      Plains    -> "GXDZGXDZSXZDGXZD" ,
      Seacoast  -> "XADZAXMZCXMZXAZM" ,
      Swamp     -> "AXZDGXZMXGMZXAMZ"
    )
    
  )

}
