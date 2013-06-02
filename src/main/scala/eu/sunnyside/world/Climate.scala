package eu.sunnyside.world

/**
 * The five climatic regions of the planet 
 */
object Climate extends Enumeration {

  type Climate = Value
  
  /**
   * From 90 degrees (north or south pole) to 66 degrees (the Arctic Circle).
   */
  val Arctic = Value("Arctic")
  
  /**
   * From 65 degrees to 51 degrees
   */
  val Subarctic = Value("Subarctic")
  
  /**
   * From 50 degrees to 31 degrees
   */
  val Temperate = Value("Temperate")
  
  /**
   * From 30 degrees to 16 degrees
   */
  val Subtropical = Value("Subtropical")
  
  /**
   * From 15 degrees to 0 degrees (the Ecuator)
   */
  val Tropical = Value("Tropical")
  
}
