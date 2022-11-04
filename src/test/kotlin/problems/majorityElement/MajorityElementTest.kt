package problems.majorityElement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class MajorityElementTest {

    @ParameterizedTest
    @MethodSource
    fun majorityElement(nums: Array<Int>, expected: Int) {
        val actual = Solution.majorityElement(nums.toIntArray())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun majorityElement(): Stream<Arguments> = Stream.of(
            Arguments.of(arrayOf(3, 2, 3), 3),
            Arguments.of(arrayOf(3), 3),
            Arguments.of(arrayOf(2, 2, 1, 1, 1, 2, 2), 2),
            Arguments.of(arrayOf(2, 1, 2, 1, 2, 1, 2), 2),
        )
    }
}