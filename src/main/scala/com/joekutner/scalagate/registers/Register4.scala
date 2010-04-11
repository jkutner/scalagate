package com.joekutner.scalagate.registers

import com.joekutner.scalagate.sequential.DFlipFlop


class Register4 {
  val a0:DFlipFlop = new DFlipFlop
  val a1:DFlipFlop = new DFlipFlop
  val a2:DFlipFlop = new DFlipFlop
  val a3:DFlipFlop = new DFlipFlop

  def in(i0:Boolean, i1:Boolean, i2:Boolean, i3:Boolean, clock:Boolean):Byte = {
    val out0 = a0.in(i0, clock);
    val out1 = a1.in(i1, clock);
    val out2 = a2.in(i2, clock);
    val out3 = a3.in(i3, clock);
    return (out0, out1, out2, out3)
  }
}