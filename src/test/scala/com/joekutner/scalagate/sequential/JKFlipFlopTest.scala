package com.joekutner.scalagate.sequential

import org.scalatest.junit.AssertionsForJUnit
import org.junit.{Assert, Test}

/**
 * This class represents a D Flip Flop that is triggered on the postive edge of a signal.
 *
 * @author jkutner
 */
class JKFlipFlopTest extends AssertionsForJUnit {

  @Test def verifyTruthTable() {

    /*
                 Q(t)  J   K  |  Q(t+1)
                ------------------------
      I    =>     0    0   0  |    0
      II   =>     0    0   1  |    0
      III  =>     0    1   0  |    1
      IV   =>     0    1   1  |    1
      V    =>     1    0   0  |    1
      VI   =>     1    0   1  |    0
      VII  =>     1    1   0  |    1
      VIII =>     1    1   1  |    0
     */

    val uut:JKFlipFlop = new JKFlipFlop

    // make sure Q is false to start with
    val q1 = uut.in(false, true, false);
    Assert.assertFalse(q1._1);

    // Inputs for I
    val q2 = uut.in(false, false, true);

    // make sure its still false
    Assert.assertFalse(q2._1);

    // set the edge back to negative
    uut.in(false, false, false);

    // Inputs for II
    val i = uut.in(false, true, true);

    // Test outputs for I
    Assert.assertFalse(i._1);

    // set the edge back to negative
    uut.in(false, true, false);

    // Inputs for III
    val ii = uut.in(true, false, true);

    // Test outputs for II
    Assert.assertFalse(ii._1);

    // set the edge back to negative
    uut.in(true, false, false);

    // Inputs for IV
    val iii = uut.in(true, true, true);

    // Test outputs for III
    Assert.assertTrue(iii._1);

    // set the edge back to negative
    uut.in(true, true, false);

    // Inputs for VII (jump to VII because of Q)
    val v = uut.in(true, false, true);

    // Test outputs for V
    Assert.assertTrue(v._1);

    // set the edge back to negative
    uut.in(true, false, false);

    // Inputs for VI (jump to VI because of Q)
    val vii = uut.in(false, true, true);

    // Test outputs for VII
    Assert.assertTrue(vii._1);

    // TODO need to test VI and VIII
//    // set the edge back to negative
//    uut.in(false, true, false);
//
//    // One more to get outputs for VI
//    val vi = uut.in(false, true, true);
//
//    // Test outputs for IV
//    Assert.assertFalse(vi._1);

  }
}