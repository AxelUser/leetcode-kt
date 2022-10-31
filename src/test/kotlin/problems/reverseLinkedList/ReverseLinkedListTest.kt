package problems.reverseLinkedList

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.toArray
import utils.toListNode
import kotlin.test.assertContentEquals

internal class ReverseLinkedListTest {

    @ParameterizedTest
    @MethodSource
    fun reverseList(list: Array<Int>, expected: Array<Int>) {
        val actual = Solution().reverseList(list.toListNode())

        assertContentEquals(expected, actual.toArray())
    }

    companion object {
        @JvmStatic
        fun reverseList() = listOf(
            Arguments.of(arrayOf(1,2,3,4,5), arrayOf(5,4,3,2,1)),
            Arguments.of(arrayOf(1,2), arrayOf(2,1)),
            Arguments.of(arrayOf(1), arrayOf(1)),
            Arguments.of(arrayOf(1), arrayOf(1)),
            Arguments.of(emptyArray<Int>(), emptyArray<Int>()),
        )
    }
}