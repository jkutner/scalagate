package com.joekutner.scalagate.primatives

class Byte extends Tuple4[Boolean,Boolean,Boolean,Boolean] {
  /**
   * The input to this method should be a Binary Coded Decimal number
   */
  def eq(lhs:Int):Boolean = {
    val rhs = 0;

    if (this._1) rhs += 1;
    if (this._2) rhs += 10;
    if (this._3) rhs += 100;
    if (this._4) rhs += 1000;

    return lhs == rhs;
  }
}