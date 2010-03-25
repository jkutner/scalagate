package com.joekutner.scalagate.sequential

import com.joekutner.scalagate.primatives.Gates

/**
 * @author jkutner
 */

class SRLatch {
  var q:Tuple2[Boolean, Boolean] = (true,true);

  def in(set:Boolean, reset:Boolean):Tuple2[Boolean, Boolean] = {
    q = SRLatch.in(set, reset, q);
    return q;
  }

  def in(set:Boolean, reset:Boolean, control:Boolean):Tuple2[Boolean, Boolean] = {
    q = SRLatch.in(set, reset, control, q);
    return q;
  }
}

object SRLatch {
  def in(set:Boolean, reset:Boolean, control:Boolean, q:Tuple2[Boolean, Boolean]):Tuple2[Boolean, Boolean] = {
    in(Gates.nand(set, control), Gates.nand(reset, control), q);
  }

  def in(set:Boolean, reset:Boolean, q:Tuple2[Boolean, Boolean]):Tuple2[Boolean, Boolean] = {
    if (!set && !reset) {
      (true, true)
    } else {
      var tempQ1 = Gates.nand(set, q._2)
      (tempQ1, !tempQ1)//Gates.nand(reset, q1)
    }
  }
}