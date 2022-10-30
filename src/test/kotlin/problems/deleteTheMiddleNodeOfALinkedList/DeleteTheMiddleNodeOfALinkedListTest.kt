package problems.deleteTheMiddleNodeOfALinkedList

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.toArray
import problems.utils.toListNode
import kotlin.test.assertContentEquals

internal class DeleteTheMiddleNodeOfALinkedListTest {

    @ParameterizedTest
    @MethodSource
    fun deleteMiddle(input: Array<Int>, expected: Array<Int>) {
        val actual = Solution.deleteMiddle(input.toListNode()).toArray()
        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun deleteMiddle() = listOf(
            Arguments.of(arrayOf(1, 3, 4, 7, 1, 2, 6), arrayOf(1, 3, 4, 1, 2, 6)),
            Arguments.of(arrayOf(1, 2, 3, 4), arrayOf(1, 2, 4)),
            Arguments.of(arrayOf(2, 1), arrayOf(2)),
            Arguments.of(arrayOf(2), arrayOf<Int>()),
        )
    }
}