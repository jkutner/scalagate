package com.joekutner.scalagate.registers

import com.joekutner.scalagate.primatives.Word

/**
 * A 32-bit register
 */
class Register {
  var value:Word

  def read = value

  def write(v:Word) {
    value = v;
  }
}