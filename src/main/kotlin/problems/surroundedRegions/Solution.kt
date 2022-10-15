package problems.surroundedRegions

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    130,
    "Surrounded Regions",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/surrounded-regions/"
)
class Solution {
    fun solve(board: Array<CharArray>) {
        val visited = HashSet<Pair<Int, Int>>()
        val flipped = HashSet<Pair<Int, Int>>()

        for (y in board.indices) {
            for (x in board[y].indices) {
                if (visited.contains(y to x)) continue

                dfs(board, y, x, visited, flipped)
            }
        }

        for (y in board.indices) {
            for (x in board[y].indices) {
                if (flipped.contains(y to x)) {
                    board[y][x] = 'X'
                }
            }
        }
    }

    private fun dfs(
        board: Array<CharArray>,
        sY: Int,
        sX: Int,
        visited: MutableSet<Pair<Int, Int>>,
        flipped: MutableSet<Pair<Int, Int>>
    ) {
        val yMax = board.size - 1
        val xMax = board[0].size - 1
        val traversed = HashSet<Pair<Int, Int>>()
        val stack = Stack<Pair<Int, Int>>()
        stack.push(sY to sX)
        var flip = true

        while (stack.isNotEmpty()) {
            val (y, x) = stack.pop()
            if (board[y][x] == 'X' || traversed.contains(y to x)) continue
            traversed.add(y to x)
            visited.add(y to x)

            if (x > 0) stack.push(y to x - 1) // left
            if (y > 0) stack.push(y - 1 to x) // up
            if (x < xMax) stack.push(y to x + 1) // right
            if (y < yMax) stack.push(y + 1 to x) // down

            if (x == 0 || y == 0 || x == xMax || y == yMax) {
                flip = false
            }
        }

        if (flip) {
            for (yx in traversed) {
                flipped.add(yx)
            }
        }

    }
}