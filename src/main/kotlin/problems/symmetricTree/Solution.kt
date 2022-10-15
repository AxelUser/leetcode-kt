package problems.symmetricTree

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(101, "Symmetric Tree", ProblemDifficulty.EASY, "https://leetcode.com/problems/symmetric-tree/")
object Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        val queueLeft: Queue<TreeNode?> = LinkedList<TreeNode?>().also { q -> root!!.left.also { q.add(it) } }
        val queueRight: Queue<TreeNode?> = LinkedList<TreeNode?>().also { q -> root!!.right.also { q.add(it) } }

        while (queueLeft.isNotEmpty() && queueRight.isNotEmpty()) {
            val leftNode = queueLeft.poll()
            val rightNode = queueRight.poll()
            if (leftNode?.`val` != rightNode?.`val`) return false

            if (leftNode != null) {
                leftNode.left.also { queueLeft.add(it) }
                leftNode.right.also { queueLeft.add(it) }
            }

            if (rightNode != null) {
                rightNode.right.also { queueRight.add(it) }
                rightNode.left.also { queueRight.add(it) }
            }
        }

        return queueLeft.isEmpty() && queueRight.isEmpty()
    }
}