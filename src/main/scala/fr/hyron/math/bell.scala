package fr.hyron.math

import scala.math._
import fr.hyron.math.factorial.logFactorial

/**
  * Created by elix on 06/11/2017.
  */
object bell {

  def s(n: Int, k: Int): BigInt = {
    // S(n,k) = S(n-1,k-1) + kS(n-1,k)
    // S(n,1) = S(n,n) = 1
    // S(n,2) = 2^(n-1) - 1
    // S(n,n-1) = n(n-1)/2
    (n-k,k) match {
      case (0,_) | (_, 1) => 1
      case (_,2) => (pow(2, n-1) - 1).toInt
      case (1, _) => n * (n - 1) /2
      case _ => s(n-1, k-1) + k * s(n-1, k)
    }
  }

  def bell(n: Int, k: Int): BigInt = (1 to k).foldLeft(BigInt(0))(_ + s(n, _))

  def dichotomie_imax(n: Int, bMin: Int, bMax: Int): Int = {
    val i_piv = ceil((bMax + bMin).toDouble / 2).toInt
    if (i_piv == bMax) {
      i_piv
    } else {
      val val_i_piv_m1 = n * log(i_piv - 1) - logFactorial(i_piv - 1)
      val val_i_piv = n * log(i_piv) - logFactorial(i_piv)
      val val_i_piv_p1 = n * log(i_piv + 1) - logFactorial(i_piv + 1)
      if (val_i_piv_m1 < val_i_piv) {
        if (val_i_piv > val_i_piv_p1) {
          i_piv
        } else {
          dichotomie_imax(n, i_piv, bMax)
        }
      } else {
        dichotomie_imax(n, bMin, i_piv)
      }
    }
  }

  private[this] val expm1_approx_array: Array[Double] = {
    val ar = new Array[Double](19)
    ar(0) = 1.0
    (1 to 18).map(i => ar(i) = ar(i - 1) + pow(-1, i) / factorial.factorial(i).toDouble)
    ar
  }


  def expm1_approx(n: Int): Double = {
    if (n <= 18)
      expm1_approx_array(n)
    else
      exp(-1)
  }

  def logBell(n: Int, k: Int): Double = {
    val i0 = dichotomie_imax(n, 1, k)
    var acc = expm1_approx(k-i0) * exp(logFactorial(i0) - logFactorial(i0))
    val sqrtn = 4 * ceil(sqrt(n)).toInt

    for (i <- i0+1 to min(k, i0 + sqrtn)) {
      acc += expm1_approx(k - i) * exp(logFactorial(i0) - logFactorial(i) + n * (log(i) - log(i0)))
    }
    for (i <- i0-1 to max(1, i0 - sqrtn) by -1) {
      acc += expm1_approx(k - i) * exp(logFactorial(i0) - logFactorial(i) + n * (log(i) - log(i0)))
    }
    acc = log(acc) + n * log(i0) - logFactorial(i0)
    acc
  }
}
