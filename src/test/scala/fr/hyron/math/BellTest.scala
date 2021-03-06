package fr.hyron.math

import org.scalatest.FunSuite
import scala.util.Random

class BellTest extends FunSuite {

  test("S(1,1)")  {
    assert(bell.s(1,1) == 1)
  }

  test("S(n,1) = S(n, n) = 1")  {
    var n = Random.nextInt(30).abs
    assert(bell.s(n,1) == 1)
    assert(bell.s(n,n) == 1)
  }

  test("S(n,2) = 2^(n-1) - 1")  {
    var n = Random.nextInt(30).abs
    assert(bell.s(n,2) == Math.pow(2, n-1).toInt - 1)
  }

  test("S(12, 5) = 1379400") {
    assert(bell.s(12, 5) == 1379400)
  }

  test("Bell(12, 5) = 2079475") {
    assert(bell.bell(12, 5) == 2079475)
  }

  test("LogBell(n,k) = log(Bell(n,k))") {
    var k = Math.max(Random.nextInt(10).abs, 1)
    var n = k + Random.nextInt(15).abs

    assert(
      Math.abs(Math.log(bell.bell(n, k).toDouble) - bell.logBell(n, k)) < Math.pow(10, -7),
      "logBell(" + n + ", " + k +")"
    )
  }

  test("LogBell(n,k) = log(Bell(n,k)) <+> 2") {
    var k = Math.max(Random.nextInt(10).abs, 1)
    var n = k + Random.nextInt(15).abs

    assert(
      Math.abs(Math.log(bell.bell(n, k).toDouble) - bell.logBell(n, k)) < Math.pow(10, -7),
      "logBell(" + n + ", " + k +")"
    )
  }


  test("LogBell(21,9) = log(Bell(21,9)) <+> 2") {
    var n = 21
    var k = 9

    assert(
      Math.abs(Math.log(bell.bell(n, k).toDouble) - bell.logBell(n, k)) < Math.pow(10, -7),
      "logBell(" + n + ", " + k +")"
    )
  }

  test("compute the probability of a partition of n elements into k parts") {
    assert(math.abs(bell.p(6,  25) - 0.00313161) < 10e-9)
    assert(math.abs(bell.p(7,  25) - 0.02110279) < 10e-9)
    assert(math.abs(bell.p(8,  25) - 0.07431024) < 10e-9)
    assert(math.abs(bell.p(9,  25) - 0.15689865) < 10e-9)
    assert(math.abs(bell.p(10, 25) - 0.21855285) < 10e-9)
    assert(math.abs(bell.p(11, 25) - 0.21526871) < 10e-9)
    assert(math.abs(bell.p(12, 25) - 0.15794784) < 10e-9)
    assert(math.abs(bell.p(13, 25) - 0.08987171) < 10e-9)
    assert(math.abs(bell.p(14, 25) - 0.04093663) < 10e-9)
    assert(math.abs(bell.p(15, 25) - 0.01531445) < 10e-9)
    assert(math.abs(bell.p(16, 25) - 0.00480507) < 10e-9)
  }

}
