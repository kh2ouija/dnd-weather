package eu.sunnyside

import org.junit._
import Assert._

import eu.sunnyside.world.time._
import eu.sunnyside.world._
import Hemisphere._
import Terrain._
import Climate._
import eu.sunnyside.world.weather._
import eu.sunnyside.world.weather.effects._

@Test
class AppTest {

  val subtropicalSeacoast = new Location(Northern, Subtropical, Seacoast)
  
  
  val m4 = Date(1990, 4, 1)
  
  
  @Test
  def testTemperatureRange() = {
    val range = TemperatureRange('C')
    assertTrue(range.from == -20)
    assertTrue(range.to == -5)
  }

  @Test
  def testMonthlyTemperatureRanges() = {
    val monthly = MonthlyTemperatureRanges(Temperate, Hills, 5) // JOT
    assertTrue(monthly.min.from == 20)
    assertTrue(monthly.med.to == 70)
    assertTrue(monthly.max.to == 85)      
  }
  
  @Test
  def testWeatherHasEffect() = {
    val oel = List(OngoingEffect(DroughtRainCooldown))
    val weather = new Weather(new DayToDayChange(0, true, 10, false, 3, 3), null, 0, null, null, null, oel)
    assertTrue(weather.hasEffect(DroughtRainCooldown))
  }
  
}


