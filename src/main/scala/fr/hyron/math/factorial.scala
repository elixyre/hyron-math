package fr.hyron.math

import breeze.numerics.lgamma

object factorial {

  def logFactorial(n: Int): Double = lgamma(n+1)

}
