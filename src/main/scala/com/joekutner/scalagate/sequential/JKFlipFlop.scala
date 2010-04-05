package com.joekutner.scalagate.sequential

import com.joekutner.scalagate.primatives.Gates

/**
 * @author jkutner
 */

class JKFlipFlop {
  val dff:DFlipFlop = new DFlipFlop

  def in(j:Boolean, k:Boolean, clock:Boolean):Tuple2[Boolean,Boolean] = {
    val a:Boolean = Gates.and(j, dff.out._2)
    val b:Boolean = Gates.and(Gates.not(k), dff.out._1)
    val d = Gates.or(a, b)
    dff.in(d, clock)
  }

  def out():Tuple2[Boolean, Boolean] = {
    dff.out
  }
}