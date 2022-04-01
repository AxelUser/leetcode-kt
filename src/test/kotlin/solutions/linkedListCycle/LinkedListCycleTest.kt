package solutions.linkedListCycle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import solutions.utils.get
import solutions.utils.toListNode

internal class LinkedListCycleTest {

    @ParameterizedTest
    @MethodSource
    fun hasCycle(array: Array<Int>, pos: Int?) {
        val head = array.toListNode()
        if (pos != null) {
            val node = head.get(pos)
            head.get(array.size - 1)!!.next = node
        }

        val actual = Solution().hasCycle(head)

        assertEquals(pos != null, actual)
    }

    companion object {
        @JvmStatic
        fun hasCycle() = listOf(
            Arguments.of(arrayOf(3,2,0,-4), 1),
            Arguments.of(arrayOf(1,2), 0),
            Arguments.of(arrayOf(1), null),
            Arguments.of(emptyArray<Int>(), null),
        )
    }
}