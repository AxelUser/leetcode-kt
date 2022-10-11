package problems.jumpGame2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class JumpGame2Test {

    @ParameterizedTest
    @MethodSource("args")
    fun jump(nums: IntArray, expected: Int) {
        val actual = Solution().jump(nums)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(2, 3, 1, 1, 4).toIntArray(), 2),
            Arguments.of(arrayOf(2, 3, 0, 1, 4).toIntArray(), 2)
        )
    }
}