package problems.rectangleArea

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class RectangleAreaTest {

    @ParameterizedTest
    @MethodSource
    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int, expected: Int) {
        val actual = Solution.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun computeArea() = listOf(
            Arguments.of(-3, 0, 3, 4, 0, -1, 9, 2, 45),
            Arguments.of(-2, -2, 2, 2, -2, -2, 2, 2, 16),
        )
    }
}