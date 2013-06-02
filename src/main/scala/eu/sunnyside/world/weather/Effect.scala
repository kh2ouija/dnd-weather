package eu.sunnyside.world.weather

import eu.sunnyside.world.weather.effects.ParticleStorm
import eu.sunnyside.world.Location
import eu.sunnyside.world.time.Date
import eu.sunnyside.world.weather.Season._
import eu.sunnyside.world.weather.effects._
import eu.sunnyside.world.weather.tables.EffectsTable

trait Effect {
  
  def duration: Int
  def code: Char
  def isSpecialWeather: Boolean
  def indefinite: Boolean
  def priority: Int
  def isVisible: Boolean
  def description = toString
  
  def influence(w: Weather, wp: Weather, l: Location, d: Date, daysTotal: Int, daysPassed: Int): Weather = w
    
  def onDayBefore: Effect = null
  def onExit: Effect = null
  
}

object Effect {
    
  def generate(existingOngoingEffects: List[OngoingEffect], location: Location, date: Date, temperature: Int, roll1: Int, roll2: Int): Effect = {
        
    val position: Int = {
      if (roll1 == 2) {
        if (roll2 <= 4) 1
        else if (roll2 <= 6) 2
        else if (roll2 == 7) 2 
        else if (roll2 <= 9) -1
        else -1
      }
      else {
        if (roll2 <= 4) -1
        else if (roll2 <= 6) -1
        else if (roll2 == 7) 2
        else if (roll2 <= 9) 3
        else 4
      }
    }
    
    if (position != -1) {    
      val (from, to) = Season(date) match {
        case Winter => (0, 4)
        case Spring => (4, 8)
        case Summer => (8, 12)
        case Autumn => (12, 16)
      }
      
      EffectsTable.table(location.climate)(location.terrain).substring(from, to).charAt(position - 1) match {
        case 'A' => ColdWave
        case 'C' => {
          if (existingOngoingEffects.find(_.effect == HurricaneCooldown) == None) {
            Hurricane  
          }
          else {
            ExtremePrecipitation(existingOngoingEffects, location.climate, temperature)
          }
        }
        case 'D' => Drought
        case 'G' => Gale
        case 'M' => Fog(location)
        case 'S' => ParticleStorm.normal(location)
        case 'T' => Tornado
        case 'X' => ExtremePrecipitation(existingOngoingEffects, location.climate, temperature)
        case 'Z' => HeatWave
      }
    }
    else {
      if (roll1 == 2) VeryStrongWind
      else VerySlightWind
    }
    
  }

}
