package problems.numberOfProvinces

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.parseInt2DArray

internal class NumberOfProvincesTest {

    @ParameterizedTest
    @MethodSource
    fun findCircleNum(isConnected: Array<Array<Int>>, expected: Int) {
        val actual = Solution.findCircleNum(isConnected.map { it.toIntArray() }.toTypedArray())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun findCircleNum() = listOf(
            Arguments.of(parseInt2DArray("[[1,1,0],[1,1,0],[0,0,1]]"), 2),
            Arguments.of(parseInt2DArray("[[1,0,0],[0,1,0],[0,0,1]]"), 3),
            Arguments.of(parseInt2DArray("[[1,1,1],[1,1,1],[1,1,1]]"), 1),
        )
    }
}