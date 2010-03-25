package com.joekutner.scalagate.sequential

import com.joekutner.scalagate.primatives.Gates

/**
 * This class represents a D Flip Flop that is triggered by the negative edge of a signal
 *
 * @author jkutner
 */

class DFlipFlopNE {
  val master:DLatch = new DLatch
  val slave:DLatch = new DLatch

  def in(d:Boolean, clock:Boolean):Tuple2[Boolean,Boolean] = {
    var o1 = master.in(d, clock);
    return slave.in(o1._1, Gates.not(clock));
  }
}