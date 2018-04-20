package fr.hyron.math

import org.scalatest.FunSuite
import scala.math.{log, abs, pow}

import fr.hyron.math.factorial.logFactorial
import scala.util.Random

class BinomialTest extends FunSuite {

  test("Log B(5, 2) = log(5!) - log(2!) - log((5-2)!)") {
    assert(binomial.logBinomial(5, 2) == logFactorial(5) - logFactorial(2) - logFactorial(5-2))
  }

  test("Log B(n, 1) = log(n)") {
    var n = Random.nextInt().abs
    assert(abs(binomial.logBinomial(n, 1) - log(n)) < pow(10,-5))

    n = Random.nextInt().abs
    assert(abs(binomial.logBinomial(n, 1) - log(n)) < pow(10,-5))

    n = Random.nextInt().abs
    assert(abs(binomial.logBinomial(n, 1) - log(n)) < pow(10,-5))
  }

  test("Log B(n, 0) = 0.0") {
    var n = Random.nextInt().abs
    assert(binomial.logBinomial(n, 0) == 0.0)

    n = Random.nextInt().abs
    assert(binomial.logBinomial(n, 0) == 0.0)

    n = Random.nextInt().abs
    assert(binomial.logBinomial(n, 0) == 0.0)
  }

  test("Log B(n, n) = 0") {
    var n = Random.nextInt().abs
    assert(binomial.logBinomial(n, n) == 0.0)

    n = Random.nextInt().abs
    assert(binomial.logBinomial(n, n) == 0.0)

    n = Random.nextInt().abs
    assert(binomial.logBinomial(n, n) == 0.0)
  }

}
