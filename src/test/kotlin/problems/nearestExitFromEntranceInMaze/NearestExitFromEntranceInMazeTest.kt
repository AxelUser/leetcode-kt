package problems.nearestExitFromEntranceInMaze

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class NearestExitFromEntranceInMazeTest {

    @ParameterizedTest
    @MethodSource
    fun nearestExit(maze: Array<Array<Char>>, entrance: Array<Int>, expected: Int) {
        val actual = Solution.nearestExit(maze.map { it.toCharArray() }.toTypedArray(), entrance.toIntArray())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun nearestExit() = listOf(
            Arguments.of(
                arrayOf(
                    arrayOf('+', '+', '.', '+'),
                    arrayOf('.', '.', '.', '+'),
                    arrayOf('+', '+', '+', '.'),
                ), arrayOf(1, 2), 1
            )
        )
    }
}