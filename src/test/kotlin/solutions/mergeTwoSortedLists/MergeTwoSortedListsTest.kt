package solutions.mergeTwoSortedLists

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import solutions.utils.toArray
import solutions.utils.toListNode
import kotlin.test.assertContentEquals

internal class MergeTwoSortedListsTest {

    @ParameterizedTest
    @MethodSource
    fun mergeTwoLists(l1: Array<Int>, l2: Array<Int>, expected: Array<Int>) {
        val actual = Solution().mergeTwoLists(l1.toListNode(), l2.toListNode()).toArray()
        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun mergeTwoLists() = listOf(
            Arguments.of(arrayOf(1,2,4), arrayOf(1,3,4), arrayOf(1,1,2,3,4,4)),
            Arguments.of(arrayOf<Int>(), arrayOf<Int>(), arrayOf<Int>()),
            Arguments.of(arrayOf<Int>(), arrayOf(0), arrayOf(0)),
        )
    }
}