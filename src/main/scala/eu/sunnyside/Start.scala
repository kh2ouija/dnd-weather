package eu.sunnyside

import eu.sunnyside.world._
import eu.sunnyside.world.weather._
import eu.sunnyside.world.weather.effects._
import Hemisphere._
import Terrain._
import Climate._
import eu.sunnyside.world.time._
import eu.sunnyside.world.tools._
import UnitSystem._

object Start {

  def main(args: Array[String]): Unit = {
    println("Welcome to Sunnyside!")

    val temperateHills = new Location(Northern, Temperate, Hills)
    val temperatePlains = new Location(Northern, Temperate, Plains)
    val arcticMountains = new Location(Northern, Arctic, Mountains)
    val subarcticPlains = new Location(Northern, Subarctic, Plains)
    val subtropicalPlains = new Location(Northern, Subtropical, Plains)
    val temperateDesert = new Location(Northern, Temperate, Desert)
    val subtropicalSeacoast = new Location(Northern, Subtropical, Seacoast)
    val subarcticSeacoast = new Location(Northern, Subarctic, Seacoast)
    
    val m4 = Date(1990, 4, 2)
    val m9 = Date(1990, 9, 1)
    val m12 = Date(1990, 12, 1)
    
    // val forecast = Forecaster.forecastFromScratch(subarcticSeacoast, m9, 100) // gale with particle storm
    // val forecast = Forecaster.forecastFromScratch(subtropicalPlains, m4, 100) // gale with precipitation
    //val forecast = Forecaster.forecastFromScratch(subarcticPlains, m12, 100) // cold wave sub-A. drought
    val forecast = Forecaster.forecastFromScratch(subtropicalSeacoast, m4, 100) // hurricane
    
    val printer = PrettyPrinter(Metric)
    
    forecast.data.foreach { dw => printer.printDate(dw._1).foreach(println); printer.printWeather(dw._2).foreach(println); println  }
    //println(printer.toXML(forecast))
    
    println("bye")
  }
  
}
