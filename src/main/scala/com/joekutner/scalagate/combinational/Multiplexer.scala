package com.joekutner.scalagate.combinational

import com.joekutner.scalagate.primatives.Gates

/**
 * @author jkutner
 */

object Multiplexer {

  // 2x1
  def in(s0:Boolean, i0:Boolean, i1:Boolean):Boolean = {
    Gates.or(
        Gates.and(s0, i0),
        Gates.and(Gates.not(s0), i1)
      )
  }

  // 4x1
  def in(s0:Boolean, s1:Boolean, i0:Boolean, i1:Boolean, i2:Boolean, i3:Boolean):Boolean = {
    Gates.or(
        Gates.and(Gates.not(s0), Gates.not(s1), i0),
        Gates.and(s0, Gates.not(s1), i1),
        Gates.and(Gates.not(s0), s1, i2),
        Gates.and(s0, s1, i3)
      )
  }

  // 8x1
  def in(s0:Boolean, s1:Boolean, s2:Boolean, i0:Boolean, i1:Boolean, i2:Boolean, i3:Boolean, i4:Boolean, i5:Boolean, i6:Boolean, i7:Boolean):Boolean = {
    Gates.or(
        Gates.and(Gates.not(s0), Gates.not(s1), Gates.not(s2), i0),
        Gates.and(s0, Gates.not(s1), Gates.not(s2), i1),
        Gates.and(Gates.not(s0), s1, Gates.not(s2), i2),
        Gates.and(s0, s1, Gates.not(s2), i3),
        Gates.and(Gates.not(s0), Gates.not(s1), s2, i4),
        Gates.and(s0, Gates.not(s1), s2, i5),
        Gates.and(Gates.not(s0), s1, s2, i6),    
        Gates.and(s0, s1, s2, i7)
      )
  }

}