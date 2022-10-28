package problems.addOneRowToTree

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    623,
    "Add One Row to Tree",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/add-one-row-to-tree/"
)
object Solution {
    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        val temp = TreeNode(0)
        temp.left = root
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(temp)
        repeat(depth - 1) {
            val count = queue.size
            repeat(count) {
                val node = queue.poll()
                node.left?.apply { queue.add(this) }
                node.right?.apply { queue.add(this) }
            }
        }

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            val prevLeft = node.left
            node.left = TreeNode(`val`)
            node.left!!.left = prevLeft

            val prevRight = node.right
            node.right = TreeNode(`val`)
            node.right!!.right = prevRight
        }

        return temp.left
    }
}