package problems.palindromeLinkedList

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.toListNode

internal class PalindromeLinkedListTest {

    @ParameterizedTest
    @MethodSource
    fun isPalindrome(input: Array<Int>, expected: Boolean) {
        val actual = Solution.isPalindrome(input.toListNode())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun isPalindrome() = listOf(
            Arguments.of(arrayOf(1, 2, 2, 1), true),
            Arguments.of(arrayOf(1, 2, 3, 2, 1), true),
            Arguments.of(arrayOf(1, 2, 3, 3, 1), false),
            Arguments.of(arrayOf(1, 2), false),
            Arguments.of(arrayOf(1), true),
        )
    }
}