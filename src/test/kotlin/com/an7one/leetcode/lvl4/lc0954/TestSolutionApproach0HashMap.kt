package com.an7one.leetcode.lvl4.lc0954

import org.junit.Test
import kotlin.test.assertFalse

class TestSolutionApproach0HashMap {
    val solution = SolutionApproach0HashMap()

    @Test
    fun test_NegativeInput_ShouldReturnExpected() {
        val input = intArrayOf(-5, -2)

        assertFalse(solution.canReorderDoubled(input))
    }
}