package problems.intersectionOfTwoLinkedLists

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.tail
import utils.toListNode

internal class IntersectionOfTwoLinkedListsTest {

    @ParameterizedTest
    @MethodSource
    fun getIntersectionNode(preA: Array<Int>, preB: Array<Int>, common: Array<Int>) {
        val commonHead = common.toListNode()
        val headA = preA.toListNode().also { it.tail()!!.next = commonHead }
        val headB = preB.toListNode().also { it.tail()!!.next = commonHead }

        val actual = Solution.getIntersectionNode(headA, headB)
        assertEquals(commonHead, actual)
    }

    companion object {
        @JvmStatic
        fun getIntersectionNode() = listOf(
            Arguments.of(arrayOf(4, 1), arrayOf(5, 6, 1), arrayOf(8, 4, 5)),
            Arguments.of(arrayOf(2, 6, 4), arrayOf(1, 5), emptyArray<Int>()),
        )
    }
}