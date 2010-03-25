package com.joekutner.scalagate.sequential

import org.scalatest.junit.AssertionsForJUnit
import org.junit.{Assert, Test}

/**
 * @author jkutner
 */

class DLatchTest extends AssertionsForJUnit {
  @Test def verifyTruthTable() {
    var uut:DLatch = new DLatch;

    var out = uut.in(false, true)
    Assert.assertEquals(false, out._1)

    out = uut.in(true, true)
    Assert.assertEquals(true, out._1)
  }
}