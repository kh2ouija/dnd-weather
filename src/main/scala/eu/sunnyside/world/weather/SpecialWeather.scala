package eu.sunnyside.world.weather

trait SpecialWeather extends Effect {
  
  override def isSpecialWeather = true
  override def isVisible = true
  
}
