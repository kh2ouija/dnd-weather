package eu.sunnyside.world.weather.tables

import eu.sunnyside.world._
import Terrain._
import Climate._

object MonthlyTemperatureRangesTable {
  
  val table = Map(
  
    Arctic -> Map(    
      Desert    -> "ABGABHACHAEHCGKFJLJKNJKMFHKDGJADHABH" ,
      Hills     -> "ABEABDACFADGBEICFIDGLDGKCFJCEHBEHACE" ,
      Mountains -> "ABEABDACFADGBEICFIDGLDGKCFJCEHBEHACE" ,
      Plains    -> "ABGABHACHAEHCGKFJLJKNJKMFHKDGJADHABH" ,
      Seacoast  -> "ACHABHACHAEJCGKFJNJKPJKNEILCGJAEIACI"      
    ),
    
    Subarctic -> Map(
      Desert    -> "ADIADJBEJCGJFKMJLNKMQJMQGKQFHMCELACI" ,
      Forest    -> "AEJAEIBGKDJLHKNJLPKMRJMRIKPEJLBHKAFJ" ,
      Hills     -> "ADIADIBFJCGJFKNJLNJMPIMPGKMDJLBGKADJ" ,
      Mountains -> "ACIADIAFJBHLEJMIKMJLNIMOGKMDJLBFKADJ" ,
      Plains    -> "ADIADJBEJCGJFKMJLNKMQJMQGKQFHMCELACI" ,
      Seacoast  -> "BFKBGKCHKDJMHKNJLRKMRKMRJLPEKMCHLAFK"    
    ),
    
    Temperate -> Map(
      Desert    -> "KMSKMTLMTMNWMPXPPZUYZUYZQWYNSXLRXKMR" ,
      Forest    -> "CFLBFKEKPHLPKNUMPVMSXMSXLPVJNRFJLDJL" ,
      Hills     -> "BILCJMEKPILRJOTJQXLTYLTYKQWJNTFKPCJM" ,
      Mountains -> "AILBIMCJNEKQFLSKOVLQXKQWINUELSCKRBJL" ,
      Plains    -> "BHMCHNDKQGLSKNULPXMSYMSYKPWGLSEKQCJM" ,
      Seacoast  -> "EJMFKNIKQKLSKMTLOWMPXMPWLOWKLTGKPEKM"
    ),
    
    Subtropical -> Map(
      Desert    -> "LPTLPUMSWNTXOTXRVYTXZTXZRUYPUYNSXMPW" ,
      Forest    -> "LTULTVMTVNTWNTXPUXPUXPUXOUWNUWMSVLSV" ,
      Hills     -> "KNQKORLQUMSVNTWOUXPUXPUYNSXMQVLPSKNR" ,
      Mountains -> "KMPKMQLPSLPTMQUNQUNPTNORLORLNQLNQKMP" ,
      Plains    -> "LNRKOSMRUNSXRVXSWYTWZTWZSVYQVYMRULPS" ,
      Seacoast  -> "LMUKMVKOWLPXMQXMSYNSYNSYMRXLQWKOUKMU"
    ),
    
    Tropical -> Map(
      Desert    -> "PRUPSTPTWPUXQVYTWZVYZVYZUXYUVXRUWQSV" ,
      Forest    -> "MUWLUWMUWOUXOUXQUXQUXQUXQUXPUXOUWMUW" ,
      Hills     -> "MPRNPTNRTPRUPTXQUYSWZSWZSVYQTWORUNQT" ,
      Mountains -> "MPRNPSNQTOQTOQUOQUNPTNPTNPTNPSMPSMPS" ,
      Plains    -> "MPRNQTNRUPRURWYTWYTWZTWZTWYRVYPSWNRU" ,
      Seacoast  -> "PSUPSVOTWQTXQTXRTYRTXRTXRTWQSVQSVPRV"
    )
    
  )

}
