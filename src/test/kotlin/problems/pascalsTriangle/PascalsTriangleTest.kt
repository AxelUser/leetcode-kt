package problems.pascalsTriangle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class PascalsTriangleTest {

    @ParameterizedTest
    @MethodSource("args")
    fun generate(numRows: Int, expected: List<List<Int>>) {
        val actualStr = Solution().generate(numRows).joinToString(",") { r -> r.joinToString(",", "[", "]") { el -> el.toString() } }

        val expectedStr = expected.joinToString(",") { r -> r.joinToString(",", "[", "]") { el -> el.toString() } }
        assertEquals(expectedStr, actualStr)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(5, listOf(listOf(1), listOf(1, 1), listOf(1, 2, 1), listOf(1, 3, 3, 1), listOf(1, 4, 6, 4, 1)))
        )
    }
}