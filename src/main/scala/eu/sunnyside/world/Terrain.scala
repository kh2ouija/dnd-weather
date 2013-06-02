package eu.sunnyside.world

object Terrain extends Enumeration {
  
  type Terrain = Value
  
  val Desert = Value("Desert")
  val Forest = Value("Forest")
  val Hills = Value("Hills")
  val Mountains = Value("Mountains")
  val Plains = Value("Plains")
  val Seacoast = Value("Seacoast")
  val Swamp = Value("Swamp")

}
