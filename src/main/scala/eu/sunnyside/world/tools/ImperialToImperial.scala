package eu.sunnyside.world.tools

object ImperialToImperial extends ImperialSystemConvertor {
  
  override def convertF(f: Int) = f + "\u00B0F"
  override def convertMph(mph: Int) = mph + "mph"
  override def convertYd(yd: Int) = yd + "yd"
  
}
