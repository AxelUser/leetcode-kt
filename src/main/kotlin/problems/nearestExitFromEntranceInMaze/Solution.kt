package problems.nearestExitFromEntranceInMaze

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    1926,
    "Nearest Exit from Entrance in Maze",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/"
)
object Solution {
    private val pos = arrayOf(0, 1, 0, -1, 0)

    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val lastRow = maze.lastIndex
        val lastCol = maze[0].lastIndex

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        with(entrance[0] to entrance[1]) {
            queue.offer(this)
            maze[first][second] = '+'
        }
        var steps = 0
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val yx = queue.poll()
                for (p in 1 until pos.size) {
                    val row = yx.first + pos[p - 1]
                    val col = yx.second + pos[p]
                    if (row in 0..lastRow && col in 0..lastCol && maze[row][col] == '.') {
                        if (row == 0 || row == lastRow || col == 0 || col == lastCol) return steps + 1
                        maze[row][col] = '+'
                        queue.offer(row to col)
                    }
                }
            }
            steps++
        }

        return -1
    }
}