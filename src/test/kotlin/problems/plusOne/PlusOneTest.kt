package problems.plusOne

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class PlusOneTest {

    @ParameterizedTest
    @MethodSource
    fun plusOne(digits: IntArray, expected: IntArray) {
        assertContentEquals(expected, Solution().plusOne(digits))
    }

    companion object {
        @JvmStatic
        fun plusOne() = listOf(
            Arguments.of(arrayOf(1,2,3).toIntArray(), arrayOf(1,2,4).toIntArray()),
            Arguments.of(arrayOf(4,3,2,1).toIntArray(), arrayOf(4,3,2,2).toIntArray()),
            Arguments.of(arrayOf(0).toIntArray(), arrayOf(1).toIntArray()),
            Arguments.of(arrayOf(9).toIntArray(), arrayOf(1, 0).toIntArray()),
            Arguments.of(arrayOf(9, 9).toIntArray(), arrayOf(1, 0, 0).toIntArray()),
            Arguments.of(arrayOf(8,9).toIntArray(), arrayOf(9, 0).toIntArray()),
        )
    }
}