package com.joekutner.scalagate.sequential

import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test
import org.junit.Assert

/**
 * @author jkutner
 */

class SRLatchTest extends AssertionsForJUnit {

  @Test def verifyTruthTable() {
    val uut:SRLatch = new SRLatch();

    // S=1, R=0
    var out = uut.in(true,false);
    Assert.assertEquals(false, out._1);
    Assert.assertEquals(true, out._2);

    // S=1, R=1 (after S=1, R=0)
    out = uut.in(true,true);
    Assert.assertEquals(false, out._1);
    Assert.assertEquals(true, out._2);

    // S=0, R=1
    out = uut.in(false,true);
    Assert.assertEquals(true, out._1);
    Assert.assertEquals(false, out._2);

    // S=1, R=1 (after S=0, R=1)
    out = uut.in(true,true);
    Assert.assertEquals(true, out._1);
    Assert.assertEquals(false, out._2);

    // S=0, R=0
    out = uut.in(false,false);
    Assert.assertEquals(true, out._1);
    Assert.assertEquals(true, out._2);

    // rinse and repeat
    out = uut.in(true,false);
    Assert.assertEquals(false, out._1);
    Assert.assertEquals(true, out._2);

    out = uut.in(true,true);
    Assert.assertEquals(false, out._1);
    Assert.assertEquals(true, out._2);

    out = uut.in(false,true);
    Assert.assertEquals(true, out._1);
    Assert.assertEquals(false, out._2);

    out = uut.in(true,true);
    Assert.assertEquals(true, out._1);
    Assert.assertEquals(false, out._2);

    out = uut.in(false,false);
    Assert.assertEquals(true, out._1);
    Assert.assertEquals(true, out._2);
  }

  @Test def verifyTruthTableWithControl() {
    val uut:SRLatch = new SRLatch();

    var out = uut.in(false,false,true);

    // S=0, R=1, C=1 => Q=0
    out = uut.in(false,true,true);
    Assert.assertEquals(false, out._1);

    out = uut.in(true,false,true);
    Assert.assertEquals(true, out._1);

    out = uut.in(true,true,true);
    Assert.assertEquals(true, out._1);
    Assert.assertEquals(true, out._2);

    // turn the clock off. no outputs should change
    out = uut.in(true,false,false);
    Assert.assertEquals(false, out._1);
    Assert.assertEquals(true, out._2);

    out = uut.in(false,true,false);
    Assert.assertEquals(false, out._1);
    Assert.assertEquals(true, out._2);

    out = uut.in(true,true,false);
    Assert.assertEquals(false, out._1);
    Assert.assertEquals(true, out._2);

    // turn the clock back on
    out = uut.in(false,false,true);
    Assert.assertEquals(false, out._1);
    Assert.assertEquals(true, out._2);     

    out = uut.in(false,true,true);
    Assert.assertEquals(false, out._1);

    out = uut.in(true,false,true);
    Assert.assertEquals(true, out._1);

    out = uut.in(true,true,true);
    Assert.assertEquals(true, out._1);
    Assert.assertEquals(true, out._2);

    // off again for good measure
    out = uut.in(true,false,false);
    Assert.assertEquals(false, out._1);
    Assert.assertEquals(true, out._2);
  }

  @Test def verifyTruthTableWithControl2() {
    val uut:SRLatch = new SRLatch();

    // S=X, R=X, C=0
    var q1 = uut.in(true,false,false);

    // S=0, R=0, C=1
    val q2 = uut.in(false,false,true);

    // S=0, R=1, C=1
    val q3 = uut.in(false,true,true);

    // S=1, R=0, C=1
    val q4 = uut.in(true,false,true);

    // S=1, R=1, C=1
    val q5 = uut.in(true,true,true);

    Assert.assertEquals(q1._1, q2._1)
    Assert.assertFalse(q3._1)
    Assert.assertTrue(q5._1)
  }
}