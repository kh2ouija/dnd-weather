package eu.sunnyside.world.weather

  import eu.sunnyside.world._
  import eu.sunnyside.world.tools.Dice
  import eu.sunnyside.world.weather._
  import eu.sunnyside.world.time._
  import Climate._
  import Terrain._
  import Season._
  import PrecipitationAmount._
  import PrecipitationForm._
  import Direction._
  import Hemisphere._
  
object ForecasterHelper {
  
  def calculateDayToDayChange(location: Location, date: Date, weatherPrev: Weather, weatherPrevPrev: Weather): DayToDayChange = {
    val extremesPrev = MonthlyTemperatureRanges(location.climate, location.terrain, date.prev.month)
    val extremesPrevPrev = MonthlyTemperatureRanges(location.climate, location.terrain, date.prev.prev.month)
    
    val dice1 = Dice.roll(6)
    val dice2 = Dice.roll(6)
    val roll = dice1 + dice2
    
    // adjust roll (only for temperature generation)
    val adjustedRoll = {        
      // rules for ending hot streak
      if (weatherPrev.temperatureRange.code == extremesPrev.max.code) {
        // if first hot day
        if ((weatherPrevPrev == null) || weatherPrevPrev.temperatureRange.code != extremesPrevPrev.max.code) {
          if (roll >= 8) 7
          else if (roll == 7) 6
          else roll
        }
        // if a 2+ hot streak is active
        else {
          if (roll >= 9) 7
          else if (roll == 7 || roll == 8) 6
          else roll
        }
      }
      // rules for ending cold streak
      else if (weatherPrev.temperatureRange.code == extremesPrev.min.code) {
        // if first cold day
        if ((weatherPrevPrev == null) || weatherPrevPrev.temperatureRange.code != extremesPrevPrev.min.code) {
          if (roll <= 6) 7
          else if (roll == 7) 8
          else roll
        }
        // if a 2+ cold streak is active
        else {
          if (roll <= 5) 7
          else if (roll == 6 || roll == 7) 8
          else roll    
        }            
      }
      // no hot or cold streak active
      else {
        roll
      }
    }
            
    DayToDayChange(adjustedRoll, dice1, dice2)
  }
  
  
  def calculateNormalTemperatureRange(location:Location, date: Date, d2dc: DayToDayChange, weatherPrev: Weather, weatherPrevPrev: Weather) = {
    val extremes = MonthlyTemperatureRanges(location.climate, location.terrain, date.month)
    val rolled = weatherPrev.temperatureRange.step(d2dc.temperatureSteps)
    
    // rule against going against month max
    if (rolled.code > extremes.max.code) {
      extremes.max
    }
    // rule against going below month min
    else if (rolled.code < extremes.min.code) {
      extremes.min
    }
    // keep rolled temperature range if legit
    else {
      rolled
    }    
  }
  
  
  def calculateNormalPrecipitation(location:Location, date: Date, d2dc: DayToDayChange, temperatureFuzzy: Int, weatherPrev: Weather, ongoingSpecialWeather: Boolean) = {
    val amount = {
      val normalAmount = {
        if (d2dc.precipitationPossible) PrecipitationAmount(location, Season(date), d2dc.dice1, d2dc.dice2)
        else None
      }   
      
      val twoSuccessiveDoubles = d2dc.doubleRoll && weatherPrev.d2dc.doubleRoll
      val noSpecialWeather = !ongoingSpecialWeather && !weatherPrev.hasSpecialWeather
    
      if (twoSuccessiveDoubles && noSpecialWeather && Dice.flipCoin) {
        PrecipitationAmount.increment(normalAmount)
      }
      else {
        normalAmount
      }
    }
    Precipitation(amount, temperatureFuzzy)
  }
  
  
  def calculateNormalWind(location: Location, season: Season, d2dc: DayToDayChange, weatherPrev: Weather) = {
    val intensity = {
      val modifiedWind = weatherPrev.wind.intensity + d2dc.windModifier
      if (modifiedWind < 0) 0
      else if ((location.climate == Arctic || location.climate == Tropical) && modifiedWind > 20) 20
      else if ((location.climate == Subarctic) && modifiedWind > 30) 30
      else if ((location.climate == Subtropical || location.climate == Temperate) && modifiedWind > 45) 45
      else modifiedWind
    }
    Wind(location, season, intensity)
  }  
  
  def calculateEffect(existingOngoingEffects: List[OngoingEffect], location: Location, date: Date, d2dc: DayToDayChange, temperature: Int) = {
    if (d2dc.effectPossible) {
      val roll2 = Dice.roll(6) + Dice.roll(6)
      Effect.generate(existingOngoingEffects, location, date, temperature, d2dc.roll, roll2)
    }
    else null
  }
  
  def humidityPass(location: Location, startDate: Date, array: Array[Weather]): Unit = {
    for (i <- 0 until array.size - 1) {
      val dToday = startDate.addDays(i)
      val previousHumidity = {
        if (i == 0) Humidity(location, Season(startDate.addDays(-1)))
        else array(i - 1).dailyHumidity.afterPrecipitation
      }
      val dh = {
        val pToday = array(i).precipitation.amount
        val pTomorrow = array(i + 1).precipitation.amount
        val (stepsBeforePrec, stepsAfterPrec) = pToday match {
          case None => pTomorrow match {
            case None => (-1, -1)
            case Light | Trace => (0, 0)
            case _ => (1, 1)
          }
          case Light | Trace => pTomorrow match {
            case None => (0, -1)
            case Light | Trace => (0, 0)
            case _ => (0, 1)
          }
          case _ => pTomorrow match {
            case None => (0, -1)
            case Light | Trace => (0, -1)
            case _ => (1, 2)
          }
        }
        DailyHumidity(previousHumidity.step(stepsBeforePrec, location, Season(dToday)), previousHumidity.step(stepsAfterPrec, location, Season(dToday)))
      }
      array(i) = array(i).applyHumidityChange(dh)
    }
  }
  
}
