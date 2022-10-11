package problems.twoSum

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TwoSumTest {

    var sut = Solution()

    @ParameterizedTest
    @MethodSource
    fun twoSum(nums: IntArray, target: Int, expected: IntArray) {
        val actual = sut.twoSum(nums, target)

        assertArrayEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun twoSum() = listOf(
            Arguments.of(arrayOf(2,7,11,15).toIntArray(), 9, arrayOf(0,1).toIntArray()),
            Arguments.of(arrayOf(3,2,4).toIntArray(), 6, arrayOf(1,2).toIntArray()),
        )
    }

}