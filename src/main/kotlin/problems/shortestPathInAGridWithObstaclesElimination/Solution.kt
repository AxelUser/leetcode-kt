package problems.shortestPathInAGridWithObstaclesElimination

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    1293,
    "Shortest Path in a Grid with Obstacles Elimination",
    ProblemDifficulty.HARD,
    "https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/"
)
object Solution {
    private val dirCompacted = arrayOf(0, 1, 0, -1, 0)

    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        val rows = grid.size
        val cols = grid[0].size

        val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
        val visited = Array(rows) { Array(cols) { BooleanArray(k + 1) } }
        queue.offer(Triple(0, 0, 0))
        visited[0][0][0] = true

        var steps = 0
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val (row, col, obs) = queue.poll()
                if (row == rows - 1 && col == cols - 1) return steps
                for (i in 1 until dirCompacted.size) {
                    val nextRow: Int = (row + dirCompacted[i - 1])
                    val nextCol: Int = col + dirCompacted[i]
                    var nextObs = obs
                    if (nextRow in 0 until rows && nextCol in 0 until cols) {
                        if (grid[row][col] == 1) nextObs++
                        if (nextObs <= k && !visited[nextRow][nextCol][nextObs]) {
                            visited[nextRow][nextCol][nextObs] = true
                            queue.offer(Triple(nextRow, nextCol, nextObs))
                        }
                    }
                }
            }
            steps++
        }

        return -1
    }
}