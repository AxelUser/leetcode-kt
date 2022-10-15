package problems.mergeKSortedLists

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.toArray
import problems.utils.toListNode
import kotlin.test.assertContentEquals

internal class MergeKSortedListsTest {

    @ParameterizedTest
    @MethodSource("args")
    fun mergeKLists(lists: Array<Array<Int>>, expected: Array<Int>) {
        val listOfLists = lists.map { it.toListNode() }.toTypedArray()
        val actual = Solution.mergeKLists(listOfLists).toArray()

        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(arrayOf(1, 4, 5), arrayOf(1, 3, 4), arrayOf(2, 6)), arrayOf(1, 1, 2, 3, 4, 4, 5, 6)),
            Arguments.of(arrayOf(arrayOf(2), arrayOf(), arrayOf(1)), arrayOf(1, 2)),
        )
    }
}