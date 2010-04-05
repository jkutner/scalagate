package com.joekutner.scalagate.sequential

import org.scalatest.junit.AssertionsForJUnit
import org.junit.{Assert, Test}

/**
 * @author jkutner
 */

class DFlipFlopTest extends AssertionsForJUnit {
  @Test def verifyNegativeEdge() {
    val uut: DFlipFlopNE = new DFlipFlopNE

    uut.in(false, false);
    Assert.assertFalse(uut.in(true, true)._1)
    //    Assert.assertFalse(uut.in(true,false)._1)
    //    Assert.assertTrue(uut.in(true,true)._1)
  }

  @Test def verifyPositiveEdge() {
    val uut: DFlipFlop = new DFlipFlop

    uut.in(false, false);
    Assert.assertFalse(uut.in(false, true)._1)
    Assert.assertFalse(uut.in(true, false)._1)
    Assert.assertTrue(uut.in(true, true)._1)
  }
}