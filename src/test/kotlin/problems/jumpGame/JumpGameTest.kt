package problems.jumpGame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class JumpGameTest {

    @ParameterizedTest
    @MethodSource
    fun canJump(nums: IntArray, expected: Boolean) {
        assertEquals(expected, Solution().canJump(nums))
    }

    companion object {
        @JvmStatic
        fun canJump() = listOf(
            Arguments.of(arrayOf(2,3,1,1,4).toIntArray(), true),
            Arguments.of(arrayOf(3,2,1,0,4).toIntArray(), false),
        )
    }
}