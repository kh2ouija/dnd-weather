package eu.sunnyside.world.weather.effects

class ModerateFog extends Fog {

  override def description = "There is a Moderate Fog at " + when + " for " + hours + " hours."
  override def toString = "Moderate Fog"
  
}
