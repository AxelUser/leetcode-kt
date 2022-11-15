package problems.countCompleteTreeNodes

import common.TreeNode
import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    222,
    "Count Complete Tree Nodes",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/count-complete-tree-nodes/"
)
object Solution {
    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        var count = 0
        while (queue.isNotEmpty()) {
            count += queue.size
            var skip = false
            repeat(queue.size) {
                val node = queue.poll()
                if (!skip) {
                    skip = node?.left?.apply { queue.offer(this) } == null
                    skip = skip || node?.right?.apply { queue.offer(this) } == null
                }
            }
        }

        return count
    }
}