/**
 * @author: Leon
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Time Complexity:     O(`nNodes`)
 * Space Complexity:    O(`nNodes`) + O(H) ~ O(`nNodes`)
 */
package com.an7one.leetcode.lvl3.lc0105

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        // not used
        // val nNodes = preorder.size

        val inorderValToIdx = HashMap<Int, Int>()
        for (idx in inorder.indices) {
            inorderValToIdx[inorder[idx]] = idx
        }

        return dfs(0, 0, inorder.lastIndex, preorder, inorder, inorderValToIdx)
    }

    private fun dfs(
        idxPreorder: Int,
        idxStartInorder: Int,
        idxEndInorder: Int,
        preorder: IntArray,
        inorder: IntArray,
        inorderValToIdx: HashMap<Int, Int>
    ): TreeNode? {
        val nNodes = preorder.size

        if (idxPreorder >= nNodes || idxStartInorder > idxEndInorder) return null

        val rootValue = preorder[idxPreorder]
        val root = TreeNode(rootValue)

        val idxRootInorder = inorderValToIdx[rootValue]!!
        val sizeLeftSubtree = idxRootInorder - idxStartInorder

        root.left = dfs(idxPreorder + 1, idxStartInorder, idxRootInorder - 1, preorder, inorder, inorderValToIdx)
        root.right =
            dfs(
                idxPreorder + sizeLeftSubtree + 1,
                idxRootInorder + 1,
                idxEndInorder,
                preorder,
                inorder,
                inorderValToIdx
            )

        return root
    }
}