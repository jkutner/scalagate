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

    // make sure nothing changes while the signal is positive
    Assert.assertFalse(uut.in(true, true)._1)
    Assert.assertFalse(uut.in(false, true)._1)
    Assert.assertFalse(uut.in(false, true)._1)
    Assert.assertFalse(uut.in(true, true)._1)

    // signal back to false so we can set things up
    Assert.assertFalse(uut.in(true, false)._1)

    // trigger it
    Assert.assertTrue(uut.in(true, true)._1)

    // make sure nothing changes while the signal is positive
    Assert.assertTrue(uut.in(true, true)._1)
    Assert.assertTrue(uut.in(false, true)._1)
    Assert.assertTrue(uut.in(false, true)._1)
    Assert.assertTrue(uut.in(true, true)._1)

    // signal back to false so we can set things up
    Assert.assertTrue(uut.in(true, false)._1)

    // trigger it
    Assert.assertTrue(uut.in(false, true)._1)

    // signal back to false so we can set things up
    Assert.assertTrue(uut.in(false, false)._1)

    // trigger it
    Assert.assertTrue(uut.in(true, true)._1)
  }

  @Test def verifyPositiveEdgeTruthTable() {

    /*
                Q(t)  D  |  Q(t+1)
               --------------------
      RowA =>    0    0  |    0
      RowB =>    0    1  |    1
      RowC =>    1    0  |    0
      RowD =>    1    1  |    1
     */

    val uut: DFlipFlop = new DFlipFlop

    // make sure Q is false to start with
    val q1 = uut.in(false, false);
    Assert.assertFalse(q1._1);

    // Inputs for RowA
    val q2 = uut.in(false, true);

    // make sure its still false
    Assert.assertFalse(q2._1);

    // set the edge back to negative
    uut.in(false, false);

    // Inputs for RowB
    val a = uut.in(true, true);

    // Test outputs for RowA
    Assert.assertFalse(a._1);

    // set the edge back to negative
    uut.in(true, false);

    // Inputs for RowC
    val b = uut.in(false, true);

    // Test outputs for RowB
    Assert.assertTrue(b._1);

    // set the edge back to negative
    uut.in(false, false);

    // Inputs for RowD
    val x = uut.in(true, true);

    // We ignore outputs for RowC because Q was
    // not postive at the time we input RowC
    //Assert.assertFalse(c._1);
    Assert.assertTrue(x._1);

    // set the edge back to negative
    uut.in(true, false);

    // Inputs for RowC again (now that Q is positive
    val d = uut.in(false, true);

    // Test outputs for RowD
    Assert.assertTrue(d._1);
    
    // set the edge back to negative
    uut.in(true, false);
                                
    // One more so we can get outputs for RowC
    val c = uut.in(false, true);

    // Test outputs for row RowC
    Assert.assertTrue(c._1);


  }
}