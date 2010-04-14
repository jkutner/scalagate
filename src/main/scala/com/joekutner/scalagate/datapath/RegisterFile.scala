package com.joekutner.scalagate.datapath

import com.joekutner.scalagate.registers.Register

/**
 * A collection of 32 32-bit registers
 */
class RegisterFile {
  val zero:Boolean // constant value 0

  val at:Register // assembler temporary

  val v0:Register // values for function results and expression eval
  val v1:Register // values for function results and expression eval
}