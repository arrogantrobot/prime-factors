#!/bin/sh
exec scala -savecompiled "$0" "$@"
!#

import scala.annotation.tailrec

object Prime {
  var count:Long = 0
  @tailrec def isPrime(num: Long, test: Long):Long = {
    count += 1
    if (num % test == 0) test
    else 
      if(test > num / test) num
      else isPrime(num, test + 1)
  }

  @tailrec def primeFactors(acc:List[Long], num: Long):List[Long] = {
    val div = isPrime(num,2)
    if (div == num) num :: acc
    else primeFactors(div :: acc, num / div)
  }
}

Prime.primeFactors(List(),args(0).toLong).map(x => println(x))

println("Took " + Prime.count + " iterations.")
