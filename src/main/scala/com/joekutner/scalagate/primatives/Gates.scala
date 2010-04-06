package com.joekutner.scalagate.primatives

/**
 * @author jkutner
 */

object Gates {

  def xor(x:Boolean, y:Boolean):Boolean = (x && !y) || (!x && y)

  def not(x:Boolean):Boolean = !x

  def eq(x:Boolean, y:Boolean):Boolean = x == y

  def buf(x:Boolean):Boolean = x

  def nand(x:Boolean, y:Boolean):Boolean = !(x && y)

  def nor(x:Boolean, y:Boolean):Boolean = !(x || y)

  def and(xs:Boolean*):Boolean = !xs.exists(x => !x)

  def or(xs:Boolean*):Boolean = xs.exists(x => x)

}