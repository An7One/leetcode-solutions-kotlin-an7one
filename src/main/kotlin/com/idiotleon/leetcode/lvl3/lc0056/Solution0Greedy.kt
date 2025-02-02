package com.idiotleon.leetcode.lvl3.lc0056

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/merge-intervals/
 *
 * Time Complexity:     O(`nIntervals` * lg(`nIntervals`)) + O(`nIntervals`) ~ O(`nIntervals` * lg(`nIntervals`))
 * Space Complexity:    O(`nIntervals`)
 */
@Suppress(UNUSED)
class Solution0Greedy {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val nIntervals = intervals.size

        intervals.sortBy { it[0] }

        val merged = ArrayDeque<IntArray>(nIntervals)
        for (interval in intervals) {
            if (merged.isEmpty() || merged.last()[1] < interval[0]) {
                merged.addLast(interval)
            } else {
                merged.last()[1] = maxOf(merged.last()[1], interval[1])
            }
        }

        return merged.toTypedArray()
    }
}