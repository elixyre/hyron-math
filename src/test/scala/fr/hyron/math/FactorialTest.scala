package fr.hyron.math

import org.scalatest.FunSuite
import scala.math.log

class FactorialTest extends FunSuite {

  test("Log Factorial 0 = 0") {
    assert(factorial.logFactorial(0) == 0.0)
  }

  test("Log Factorial 1 = 0") {
    assert(factorial.logFactorial(1) == 0.0)
  }

  test("Log Factorial 2 = log(2)") {
    assert(factorial.logFactorial(2) == log(2))
  }

  test("Log Factorial 3 = log(2) + log(3)") {
    assert(factorial.logFactorial(3) == log(2) + log(3))
  }

  test("Log Factorial 5 = log(2) + log(3) + log(4) + log(5)") {
    assert(factorial.logFactorial(5) == log(2) + log(3) + log(4) + log(5))
  }

}

