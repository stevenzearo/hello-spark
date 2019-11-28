package steve.leetcode

import scala.collection.mutable

/**
 * @author steve
 *
 *         你的初始能量为 P，初始分数为 0，只有一包令牌。
 *
 *         令牌的值为 token[i]，每个令牌最多只能使用一次，可能的两种使用方法如下：
 *
 *         如果你至少有 token[i] 点能量，可以将令牌置为正面朝上，失去 token[i] 点能量，并得到 1 分。
 *         如果我们至少有 1 分，可以将令牌置为反面朝上，获得 token[i] 点能量，并失去 1 分。
 *
 *         在使用任意数量的令牌后，返回我们可以得到的最大分数。
 *
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/bag-of-tokens
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *         示例 1：
 *
 *         输入：tokens = [100], P = 50
 *         输出：0
 *
 *         示例 2：
 *
 *         输入：tokens = [100,200], P = 150
 *         输出：1
 *
 *         示例 3：
 *
 *         输入：tokens = [100,200,300,400], P = 200
 *         输出：2
 *
 *         来源：力扣（LeetCode）
 *         链接：https://leetcode-cn.com/problems/bag-of-tokens
 *         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object Solution {
    def bagOfTokensScore(tokens: Array[Int], P: Int): Int = {
      var score: Int = 0
      val i: Int = 0
      var energy: Int = tokens(i)
      val turnUp: Boolean = false
      if (P > tokens(i)) {
        energy -= tokens(i)
        score += 1
      }
      // todo get max score
      return score
      0
    }

  def bagOfTokensScore(tokens: Array[Int], P: Int, scores: mutable.Buffer[Int]): (Array[Int], Int, mutable.Buffer[Int]) = {
    var copyOfTokens: Array[Int] = tokens
    while (P > tokens.min){

      scores.append()
    }

    (Array(0), 0, mutable.Buffer(0))
  }
}
