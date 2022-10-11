package problems.addTwoNumbers

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.toListNode
import problems.utils.toArray
import kotlin.test.assertContentEquals

internal class AddTwoNumbersTest {

    var sut = Solution()

    @ParameterizedTest
    @MethodSource
    fun addTwoNumbers(l1: Array<Int>, l2: Array<Int>, expected: Array<Int>) {
        val actual = sut.addTwoNumbers(l1.toListNode(), l2.toListNode())

        assertContentEquals(expected, actual.toArray())
    }


    companion object {
        @JvmStatic
        fun addTwoNumbers() = listOf(
            Arguments.of(arrayOf(2, 4, 3), arrayOf(5, 6, 4), arrayOf(7, 0, 8)),
            Arguments.of(arrayOf(0), arrayOf(0), arrayOf(0)),
            Arguments.of(arrayOf(9, 9, 9, 9, 9, 9, 9), arrayOf(9, 9, 9, 9), arrayOf(8, 9, 9, 9, 0, 0, 0, 1)),
        )
    }
}