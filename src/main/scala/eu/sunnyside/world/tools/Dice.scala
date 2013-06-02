package eu.sunnyside.world.tools

import scala.util.Random

object Dice {
  
  val rnd = new Random
  
  def roll(n: Int) = rnd.nextInt(n) + 1
  def flipCoin = if (roll(2) == 1) true else false

}
