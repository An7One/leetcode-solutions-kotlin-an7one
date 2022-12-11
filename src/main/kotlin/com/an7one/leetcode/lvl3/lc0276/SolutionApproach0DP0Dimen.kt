/**
 * https://leetcode.com/problems/paint-fence/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/paint-fence/discuss/71156/O(n)-time-java-solution-O(1)-space/151116
 *  https://youtu.be/FLbqgyJ-70I?t=1430
 *  https://docs.google.com/presentation/d/1OeA0rsnOrklarLM5G2tHHJ6EE37HpRqD7KedzOqkihk/edit#slide=id.g8285dd8f3f_1_331
 */
package com.an7one.leetcode.lvl3.lc0276

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/paint-fence/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`1k`)
 */
@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun numWays(n: Int, k: Int): Int {
        // sanity check
        if (n <= 0) return 0

        // the previous two are of the same color
        var same = 0
        // the previous two are of the different colors
        var diff = k

        for (repeat in 1 until n) {
            val prevSame = same
            same = diff
            diff = (prevSame + diff) * (k - 1)
        }

        return same + diff
    }
}