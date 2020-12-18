package org

import org.scalatest.FunSuite

class flightAnalysisTest extends FunSuite {
  import org.util.utilTest.testsc

  test("Should get the count for Airport") {
    flightAnalysis.airportcount
  }

  test("should get flight"){
    flightAnalysis.flightsum
  }

  test("should second order"){  //34s
    flightAnalysis.flightSecondOrder
  }

  test("should get second order"){ //21s
    flightAnalysis.flightSecondOrderv2
  }

  test("should get second order sortbykey") {
    flightAnalysis.flight_sortbykey
  }

  test("should get second order sortby") {
    flightAnalysis.flight_sortby
  }

}
