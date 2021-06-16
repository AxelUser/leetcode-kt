package solutions.containerWithMostWater

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ContainerWithMostWaterTest {

    @ParameterizedTest
    @MethodSource
    fun maxArea(height: IntArray, expected: Int) {
        assertEquals(expected, Solution().maxArea(height))
    }

    companion object {
        @JvmStatic
        fun maxArea() = listOf(
            Arguments.of(arrayOf(1,8,6,2,5,4,8,3,7).toIntArray(), 49),
            Arguments.of(arrayOf(1,1).toIntArray(), 1),
            Arguments.of(arrayOf(4,3,2,1,4).toIntArray(), 16),
            Arguments.of(arrayOf(1,2,1).toIntArray(), 2),
        )
    }
}