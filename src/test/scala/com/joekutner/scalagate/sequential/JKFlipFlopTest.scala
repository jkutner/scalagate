package com.joekutner.scalagate.sequential

import org.scalatest.junit.AssertionsForJUnit
import org.junit.{Assert, Test}

/**
 * @author jkutner
 */

class JKFlipFlopTest extends AssertionsForJUnit {

  @Test def verifyTruthTable() {
    val uut:JKFlipFlop = new JKFlipFlop

    uut.in(false, false, false)
    val qt = uut.in(false, false, true)

    uut.in(false, false, false)

    Assert.assertEquals(qt, uut.in(false, false, true))

    uut.in(false, true, false)

    Assert.assertEquals((false,true), uut.in(false, true, true))
//    Assert.assertEquals(qt._1, uut.in(false, true, true)._1)


  }
}