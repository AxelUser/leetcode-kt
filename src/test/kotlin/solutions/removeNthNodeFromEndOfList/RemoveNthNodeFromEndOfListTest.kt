package solutions.removeNthNodeFromEndOfList

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import solutions.utils.toArray
import solutions.utils.toListNode
import kotlin.test.assertContentEquals

internal class RemoveNthNodeFromEndOfListTest {

    @ParameterizedTest
    @MethodSource
    fun removeNthFromEnd(list: Array<Int>, n: Int, expected: Array<Int>) {
        val actual = Solution().removeNthFromEnd(list.toListNode(), n)
        assertContentEquals(expected, actual.toArray())
    }

    companion object {
        @JvmStatic
        fun removeNthFromEnd() = listOf(
            Arguments.of(arrayOf(1,2,3,4,5), 2, arrayOf(1,2,3,5)),
            Arguments.of(arrayOf(1), 1, arrayOf<Int>()),
            Arguments.of(arrayOf(1,2), 1, arrayOf(1))
        )
    }
}