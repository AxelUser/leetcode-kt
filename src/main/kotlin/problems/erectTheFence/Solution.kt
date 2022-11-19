package problems.erectTheFence

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(587, "Erect the Fence", ProblemDifficulty.HARD, "https://leetcode.com/problems/erect-the-fence/")
object Solution {
    private fun orientation(p: IntArray, q: IntArray, r: IntArray): Int {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])
    }

    fun outerTrees(trees: Array<IntArray>): Array<IntArray> {
        trees.sortWith(Comparator<IntArray> { p, q ->
            if (q[0] == p[0]) q[1] - p[1] else q[0] - p[0]
        })

        val hull = Stack<IntArray>()
        for (p in trees) {
            while (hull.size >= 2 && orientation(hull[hull.size - 2], hull[hull.size - 1], p) > 0) {
                hull.pop()
            }
            hull.push(p)
        }
        hull.pop()
        for (i in trees.size - 1 downTo 0) {
            while (hull.size >= 2 && orientation(hull[hull.size - 2], hull[hull.size - 1], trees[i]) > 0) {
                hull.pop()
            }
            hull.push(trees[i])
        }
        return hull.toSet().toTypedArray()
    }
}