package com.idiotleon.leetcode.lvl4.lc1210

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/
 *
 * Time Complexity:     O(`n` ^ 2)
 * Space Complexity:    O(`n` ^ 2)
 *
 * Reference:
 * https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/discuss/393511/JavaPython-3-25-and-17-liner-clean-BFS-codes-w-brief-explanation-and-analysis.
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    private companion object {
        private const val EMPTY = 0

        // not used
        // private const val BLOCKED = 1
    }

    fun minimumMoves(grid: Array<IntArray>): Int {
        val n = grid.size

        val start = State(0, 0, Facing.RIGHT)
        val target = State(n - 1, n - 2, Facing.RIGHT)

        // to keep track of the tail of the snake,
        // so it is required to check 2 steps in the front, to move towards the facing direction
        val queue = ArrayDeque<State>().also {
            it.addLast(start)
        }

        val seen = HashSet<String>()

        var steps = 0

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()
                if (cur == target) return steps

                val row = cur.row
                val col = cur.col
                val dir = cur.dir

                if (!seen.add(cur.toHash())) continue

                if (dir == Facing.RIGHT) { // facing right
                    if (row + 1 < n && grid[row + 1][col] == EMPTY && grid[row + 1][col + 1] == EMPTY) { // to check if both cells down are available (while facing right)
                        queue.offer(State(row, col, Facing.DOWN)) // to rotate clockwise (while facing right)
                        queue.offer(State(row + 1, col, Facing.RIGHT)) // to move down (while facing right)
                    }

                    if (col + 2 < n && grid[row][col + 2] == EMPTY) { // to check if the cell in front of the snake head is available (while facing right)
                        queue.offer(State(row, col + 1, Facing.RIGHT)) // to move right (while facing right)
                    }

                }

                if (dir == Facing.DOWN) { // facing down
                    if (col + 1 < n && grid[row][col + 1] == EMPTY && grid[row + 1][col + 1] == EMPTY) { // to check if both cells right are available (while facing down)
                        queue.offer(State(row, col, Facing.RIGHT)) // to rotate anti-clockwise (while facing down)
                        queue.offer(State(row, col + 1, Facing.DOWN)) // to move right (while facing down)
                    }

                    if (row + 2 < n && grid[row + 2][col] == EMPTY) { // to check if the cell in front of the snake head is available (while facing down)
                        queue.offer(State(row + 1, col, Facing.DOWN)) // to move down (while facing down)
                    }
                }
            }

            ++steps
        }

        return -1
    }

    private data class State(val row: Int, val col: Int, val dir: Facing) {

        fun toHash(): String = "$row#$col#$dir"

        override fun equals(other: Any?) = (other is State) && row == other.row && col == other.col && dir == other.dir

        override fun hashCode(): Int {
            return super.hashCode()
        }
    }

    private enum class Facing {
        DOWN, RIGHT
    }
}