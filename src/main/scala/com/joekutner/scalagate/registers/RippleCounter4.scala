package com.joekutner.scalagate.registers

import com.joekutner.scalagate.sequential.JKFlipFlop

/**
 * This class represents an IC Type 7493 Ripple Counter (4-bit)
 *
 * Ugh, i think the JKFlipFlops need to be negative edge triggered.
 */
class RippleCounter4 {
  val qa:JKFlipFlop = new JKFlipFlop;
  val qb:JKFlipFlop = new JKFlipFlop;
  val qc:JKFlipFlop = new JKFlipFlop;
  val qd:JKFlipFlop = new JKFlipFlop;


}