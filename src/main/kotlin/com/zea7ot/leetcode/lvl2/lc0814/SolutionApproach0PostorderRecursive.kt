/**
 * https://leetcode.com/problems/binary-tree-pruning/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/binary-tree-pruning/discuss/122730/C++JavaPython-Self-Explaining-Solution-and-2-lines/247755
 *  https://leetcode.com/problems/binary-tree-pruning/discuss/122730/C%2B%2BJavaPython-Self-Explaining-Solution-and-2-lines
 */
package com.zea7ot.leetcode.lvl2.lc0814

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun pruneTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        if (postorder(root) == 0) return null

        return root
    }

    private fun postorder(node: TreeNode?): Int {
        if (node == null) return 0

        val left = postorder(node.left)
        val right = postorder(node.right)

        node.left = if (left == 0) null else node.left
        node.right = if (right == 0) null else node.right
        return left + right + node.`val`
    }
}