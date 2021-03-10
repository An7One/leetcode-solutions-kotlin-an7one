package com.an7one.leetcode.lvl3.lc0890

import org.junit.Test
import kotlin.test.assertEquals

class SolutionApproach0LinearScanTest {
    private val solution = SolutionApproach0LinearScan()

    @Test
    fun test_SampleInput1_ShouldReturnExpected() {
        val words = arrayOf("abc", "deq", "mee", "aqq", "dkd", "ccc")
        val pattern = "abb"

        val expected = listOf("mee", "aqq")

        assertEquals(expected, solution.findAndReplacePattern(words, pattern))
    }
}