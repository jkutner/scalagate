package com.joekutner.scalagate.primatives

/**
 * @author jkutner
 */

object Gates {

  def and(x:Boolean, y:Boolean):Boolean = x && y

  def xor(x:Boolean, y:Boolean):Boolean = (x && !y) || (!x && y)

  def not(x:Boolean):Boolean = !x

  def or(x:Boolean, y:Boolean):Boolean = x || y

  def eq(x:Boolean, y:Boolean):Boolean = x == y

  def buf(x:Boolean):Boolean = x

  def nand(x:Boolean, y:Boolean):Boolean = !(x && y)

  def nor(x:Boolean, y:Boolean):Boolean = !(x || y)

}