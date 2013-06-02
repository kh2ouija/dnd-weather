package eu.sunnyside.world.tools

object Gaussian {

  /**
   * Standard normal distribution
   */
  def snd(x: Double) = (1 / Math.sqrt(2 * Math.Pi)) * Math.pow(Math.E, - (x *x / 2))
  
  /**
   * Probability density function
   */
  def pdf(x: Double, mean: Double, variation: Double) = (1 / Math.sqrt(variation)) * snd((x - mean) / Math.sqrt(variation)) 
  
}
