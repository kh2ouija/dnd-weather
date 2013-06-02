package eu.sunnyside.world.weather.tables

import eu.sunnyside.world._
import Climate._
import Terrain._

object PrecipitationAmountTable {
  
  val table = Map(
  
    Arctic -> Map(    
      Desert    -> "-T--T--T--T-" ,
      Hills     -> "--T--T--T--T" ,
      Mountains -> "--T--T--T--T" ,
      Plains    -> "-TT-LT-ML-TT" ,
      Seacoast  -> "-T--LT-LT-LT"      
    ),
    
    Subarctic -> Map(
      Desert    -> "-T---T--T-T-" ,
      Forest    -> "-LTTMLTMLTLT" ,
      Hills     -> "-TT-LTTLL-LT" ,
      Mountains -> "-TTTMLTLT-LT" ,
      Plains    -> "-LTTMLTMLTLT" ,
      Seacoast  -> "-TT-LTTML-LT" ,
      Swamp     -> "-LTTMLTLLTLL"
    ),
    
    Temperate -> Map(
      Desert    -> "-T--T--T----" ,
      Forest    -> "TMLLHMLMMLMM" ,
      Hills     -> "TMLLHMLHMTML" ,
      Mountains -> "-ML-ML-LT-ML" ,
      Plains    -> "-LTLHMLHMTML" ,
      Seacoast  -> "LHMTML-LTLHM" ,
      Swamp     -> "TMLLHLLHM-ML"
    ),
    
    Subtropical -> Map(
      Desert    -> "-T--T-----T-" ,
      Forest    -> "MHHMDHMDHMHH" ,
      Hills     -> "TLLLHMLHMTML" ,
      Mountains -> "TMLLHMLMMTML" ,
      Plains    -> "-LTTHLTML-LT" ,
      Seacoast  -> "TMLLHMLDM-LT" ,
      Swamp     -> "TLLTMLTHLTLL"
    ),
    
    Tropical -> Map(
      Desert    -> "-T--LT-T--T-" ,
      Forest    -> "MDHMDHMDHMDH" ,
      Hills     -> "-T--LTTML-T-" ,
      Mountains -> "TMLMHHTMLMHH" ,
      Plains    -> "-T-LHMMHMLHM" ,
      Seacoast  -> "-T-LDMHDD-LT" ,
      Swamp     -> "-LTMHHMHMLMM"
    )
    
  )

}
