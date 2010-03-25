package com.joekutner.scalagate.combinational

import com.joekutner.scalagate.primatives.Gates

/**
 * @author jkutner
 */

object Adder {
  def half(x:Boolean, y:Boolean):Tuple2[Boolean, Boolean] = {
    val sum = Gates.xor(x, y);
    val carry = Gates.and(x, y);
    (sum, carry);
  }

  def full(x:Boolean, y:Boolean, z:Boolean):Tuple2[Boolean, Boolean] = {
    val halfOne = half(x, y);
    val halfTwo = half(halfOne._1, z);
    val carry = Gates.or(halfOne._2, halfTwo._2);
    (halfTwo._1, carry)
  }
}