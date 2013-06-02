package eu.sunnyside.world.weather.effects

class HeavyFog extends Fog {

  override def description = "There is a Heavy Fog at " + when + " for " + hours + " hours."
  override def toString = "Heavy Fog"
  
}
