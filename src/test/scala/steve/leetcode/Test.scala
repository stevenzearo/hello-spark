package steve.leetcode

/**
 * @author steve
 */
object Test {
  def main(args: Array[String]): Unit = {
    println(fun1(1))
  }

  @scala.annotation.tailrec
  def fun1(num: BigDecimal, result: BigDecimal = 1): BigDecimal = {
    if (num <= 1) result else fun1(num-1, num*result)
  }
}
