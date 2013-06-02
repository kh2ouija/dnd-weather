package eu.sunnyside.world

/**
 * The two hemispheres of the planet.
 */
object Hemisphere extends Enumeration {

  type Hemisphere = Value
  
  /**
   * The Northern hemisphere
   */
  val Northern = Value("Northern")
  
  /**
   * The Southern hemisphere
   */
  val Southern = Value("Southern")
  
}
