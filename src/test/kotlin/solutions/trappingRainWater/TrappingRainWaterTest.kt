package solutions.trappingRainWater

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

internal class TrappingRainWaterTest {

    @ParameterizedTest
    @MethodSource
    fun trap(height: IntArray, expected: Int) {
        assertEquals(expected, Solution().trap(height))
    }

    companion object {
        @JvmStatic
        fun trap() = listOf(
            //Arguments.of(arrayOf(1, 0, 1).toIntArray(), 1),
            Arguments.of(arrayOf(1, 0, 0, 2).toIntArray(), 2),
            Arguments.of(arrayOf(2, 0, 0, 1).toIntArray(), 2),
            Arguments.of(arrayOf(0,1,0,2,1,0,1,3,2,1,2,1).toIntArray(), 6),
            Arguments.of(arrayOf(4,2,0,3,2,5).toIntArray(), 9),
            Arguments.of(arrayOf(0, 1, 2).toIntArray(), 0),
            Arguments.of(arrayOf(2, 1, 0).toIntArray(), 0),
            Arguments.of(arrayOf(0, 0, 0).toIntArray(), 0),
            Arguments.of(arrayOf(6).toIntArray(), 0),
            Arguments.of(arrayOf<Int>().toIntArray(), 0),
        )
    }
}