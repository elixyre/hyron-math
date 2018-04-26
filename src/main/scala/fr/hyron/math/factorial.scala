package fr.hyron.math

import breeze.numerics.lgamma

object factorial {

  def logFactorial(n: Int): Double = lgamma(n+1)

  def factorial(n: Int, acc: Int = 1): Int = {
    if (n <= 1) return acc
    else return factorial(n-1, acc * n)
  }

}
