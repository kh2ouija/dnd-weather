package eu.sunnyside.world.weather

trait InternalEffect extends Effect {

  override def isSpecialWeather = false
  override def isVisible = false
  
}
