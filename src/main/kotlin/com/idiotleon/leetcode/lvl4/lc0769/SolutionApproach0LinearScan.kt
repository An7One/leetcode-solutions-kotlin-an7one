package com.idiotleon.leetcode.lvl4.lc0769

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 *
 * Time Complexity:     O(2 * `totalNums`) ~ O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * Two passes
 *
 *  "Each time all elements to the left are smaller than, or equal to,
 *  all elements to the right, there is a new chunk."
 *
 * Reference:
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii/discuss/113462/Java-solution-left-max-and-right-min./182522
 * https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113520/Java-solution-left-max-and-right-min.
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun maxChunksToSorted(nums: IntArray): Int {
        val nNums = nums.size

        val minFromHi = IntArray(nNums) { 0 }

        var hiMin = Int.MAX_VALUE
        for (idx in minFromHi.indices.reversed()) {
            hiMin = minOf(hiMin, nums[idx])
            minFromHi[idx] = hiMin
        }

        var chunks = 0

        var loMax = Int.MIN_VALUE
        for (idx in 0 until nNums - 1) {
            loMax = maxOf(loMax, nums[idx])

            if (loMax <= minFromHi[idx + 1]) {
                ++chunks
            }
        }

        return 1 + chunks
    }
}