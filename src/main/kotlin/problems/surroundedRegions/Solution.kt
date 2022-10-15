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
        // left & right
        for (y in board.indices) {
            bfs(board, y, 0)
            bfs(board, y, board[y].size - 1)
        }

        // top & bottom
        for (x in board[0].indices) {
            bfs(board, 0, x)
            bfs(board, board.size - 1, x)
        }

        for (y in board.indices) {
            for (x in board[y].indices) {
                when (board[y][x]) {
                    'O' -> board[y][x] = 'X'
                    'F' -> board[y][x] = 'O'
                }
            }
        }
    }

    private fun bfs(board: Array<CharArray>, sY: Int, sX: Int) {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(sY to sX)

        while (queue.isNotEmpty()) {
            val (y, x) = queue.removeFirst()
            if (board[y][x] != 'O') continue
            queue.addAll(board.getAdjacent(y, x))
            board[y][x] = 'F'
        }
    }

    private fun Array<CharArray>.getAdjacent(y: Int, x: Int): Sequence<Pair<Int, Int>> {
        val maxY = size - 1
        val maxX = this[0].size - 1

        return sequence {
            if (x > 0) yield(y to x - 1)
            if (y > 0) yield(y - 1 to x)
            if (x < maxX) yield(y to x + 1)
            if (y < maxY) yield(y + 1 to x)
        }.filter { (y, x) -> this[y][x] == 'O' }
    }
}