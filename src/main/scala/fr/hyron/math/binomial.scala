package fr.hyron.math

import fr.hyron.math.factorial.logFactorial

object binomial {

  def logBinomial(n: Int, k: Int): Double = {
    logFactorial(n) - logFactorial(k) - logFactorial(n - k)
  }

  def logMultinomial(nk: Int, nki: Array[Int]): Double = {
    logFactorial(nk) - nki.foldLeft(0.0)(_ + logFactorial(_))
  }

}
