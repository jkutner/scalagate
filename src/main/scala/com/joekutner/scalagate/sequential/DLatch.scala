package com.joekutner.scalagate.sequential

import com.joekutner.scalagate.primatives.Gates

/**
 * @author jkutner
 */

class DLatch {

  var q:Tuple2[Boolean,Boolean] = (true, true)

  def in(d:Boolean, control:Boolean):Tuple2[Boolean,Boolean] = {
    q = SRLatch.in(Gates.nand(d, control), Gates.nand(!d, control), q)
    return q
  }

}