package fr.hyron.math

import fr.hyron.math.factorial.{logFactorial}

object binomial {

  def binomial(n: Int, k: Int): Int = {
    val fn: Int = factorial.factorial(n)
    val fk: Int = factorial.factorial(k)
    val fnk: Int = factorial.factorial(n-k)
    fn / (fk * fnk)
  }

  def logBinomial(n: Int, k: Int): Double = {
    logFactorial(n) - logFactorial(k) - logFactorial(n - k)
  }

  def logMultinomial(nk: Int, nki: Array[Int]): Double = {
    logFactorial(nk) - nki.foldLeft(0.0)(_ + logFactorial(_))
  }

}
