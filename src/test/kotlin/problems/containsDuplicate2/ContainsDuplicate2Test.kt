package problems.containsDuplicate2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ContainsDuplicate2Test {

    @ParameterizedTest
    @MethodSource
    fun containsNearbyDuplicate(nums: Array<Int>, k: Int, expected: Boolean) {
        val actual = Solution.containsNearbyDuplicate(nums.toIntArray(), k)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun containsNearbyDuplicate() = listOf(
            Arguments.of(arrayOf(1, 2, 3, 1), 3, true),
            Arguments.of(arrayOf(1, 0, 1, 1), 1, true),
            Arguments.of(arrayOf(1, 2, 3, 1, 2, 3), 2, false),
            Arguments.of(arrayOf(1, 1), 0, false),
            Arguments.of(arrayOf(1), 5, false),
            Arguments.of(arrayOf(1, 2, 1), 5, true),
        )
    }
}