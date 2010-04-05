package com.joekutner.scalagate.sequential

/**
 * This class represents a D Flip Flop that is triggered on the postive edge of a signal.
 *
 * @author jkutner
 */

class DFlipFlop {
  val sr1:SRLatch = new SRLatch;
  val sr2:SRLatch = new SRLatch;
  val sr3:SRLatch = new SRLatch;

  def in(d:Boolean, c:Boolean):Tuple2[Boolean,Boolean] = {
    var out1 = sr1.in(c, d);
    var out2 = sr2.in(out1._2, c);
    return sr3.in(out2._2, out1._1);
  }

  def out():Tuple2[Boolean, Boolean] = {
    sr3.out
  }
}