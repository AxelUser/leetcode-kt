package problems.numberOfIslands

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(200, "Number of Islands", ProblemDifficulty.MEDIUM, "https://leetcode.com/problems/number-of-islands/")
object Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val maxY = grid.size - 1
        val maxX = grid[0].size - 1
        var count = 0
        for (y in 0..maxY) {
            for (x in 0..maxX) {
                if (grid[y][x] == '1') {
                    count++
                    markBfs(grid, y, x, maxY, maxX)
                }
            }
        }

        return count
    }

    private fun markBfs(grid: Array<CharArray>, sY: Int, sX: Int, maxY: Int, maxX: Int) {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(sY to sX)
        while (queue.isNotEmpty()) {
            val (y, x) = queue.poll()
            if (grid[y][x] != '1') continue
            grid[y][x] = '#'

            if (x > 0 && grid[y][x - 1] == '1') queue.add(y to x - 1)
            if (y > 0 && grid[y - 1][x] == '1') queue.add(y - 1 to x)
            if (x < maxX && grid[y][x + 1] == '1') queue.add(y to x + 1)
            if (y < maxY && grid[y + 1][x] == '1') queue.add(y + 1 to x)
        }
    }
}