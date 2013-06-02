package eu.sunnyside.world.weather.effects

import eu.sunnyside.world.weather.SpecialWeather
import eu.sunnyside.world._
import Terrain._
import Climate._

abstract class ParticleStorm extends SpecialWeather {

  val code = 'S'
  def duration = 1 //
  val indefinite = false
  val priority = 10
  
  override def toString = "Particle Storm"
  
}


object ParticleStorm {
  
  def normal(l: Location): ParticleStorm = {
    if (l.terrain == Desert) new Sandstorm
    else if (l.climate == Arctic || l.climate == Subarctic) new BlowingSnow
    else new DustStorm
  }
  
  def severe(l: Location): ParticleStorm = {
    if (l.terrain == Desert) new SevereSandstorm
    else if (l.climate == Arctic || l.climate == Subarctic) new SevereBlowingSnow
    else new SevereDustStorm
  }
 
}