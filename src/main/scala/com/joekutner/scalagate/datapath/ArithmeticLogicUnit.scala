package com.joekutner.scalagate.datapath

import com.joekutner.scalagate.primatives.{Gates, Word}

/**
 * A 32-bit ALU
 */
class ArithmeticLogicUnit {

  var op:Byte
  
  var operand1:Word
  var operand2:Word

  var zero:Boolean
  var output:Word

  def clock {
    // do stuff to the operands based on the control - store it in output

    if (op.eq(0000)) {
      // AND
    } else if (op.eq(0001)) {
      // OR
    } else if (op.eq(0010)) {
      // add
    } else if (op.eq(0011)) {
      // ?
    } else if (op.eq(0100)) {
      // ?
    } else if (op.eq(0101)) {
      // ?
    } else if (op.eq(0110)) {
      // subtract
    } else if (op.eq(0111)) {
      // set on less than
    } else if (op.eq(1000)) {
      // ?
    } else if (op.eq(1001)) {
      // ?
    } else if (op.eq(1010)) {
      // ?
    } else if (op.eq(1011)) {
      // ?
    } else if (op.eq(1100)) {
      // NOR
    } else if (op.eq(1101)) {
      // ?
    } else if (op.eq(1110)) {
      // ?
    } else if (op.eq(1111)) {
      // ?
    }
  }

}