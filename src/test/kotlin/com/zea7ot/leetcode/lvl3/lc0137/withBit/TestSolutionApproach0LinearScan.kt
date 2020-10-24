package com.zea7ot.leetcode.lvl3.lc0137.withBit

import org.junit.Test
import kotlin.test.assertEquals

class TestSolutionApproach0LinearScan {
    private val solution = SolutionApproach0LinearScan()

    @Test
    fun test() {
        val input = intArrayOf(2, 2, 3, 2)
        val expected = 3

        assertEquals(expected, solution.singleNumber(input))
    }
}