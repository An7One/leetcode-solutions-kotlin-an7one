/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * Time Complexity:     O(`nPts`)
 * Space Complexity:    O(`k`)
 */
package com.an7one.leetcode.lvl2.lc0973

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MaxHeap {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        // not used
        // val nPts = points.size
        val maxHeap = PriorityQueue<IntArray>(compareBy { -getDistance(it[0], it[1]) })

        for (point in points) {
            maxHeap.offer(point)
            if (maxHeap.size > k)
                maxHeap.poll()
        }

        val ans = Array(k) { IntArray(2) { 0 } }
        var idx = k - 1
        while (maxHeap.isNotEmpty()) {
            ans[idx--] = maxHeap.poll()
        }

        return ans
    }

    private fun getDistance(row: Int, col: Int): Long = row.toLong() * row.toLong() + col.toLong() * col.toLong()
}