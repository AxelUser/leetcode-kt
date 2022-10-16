package problems.linkedListCycle2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.get
import problems.utils.loop
import problems.utils.toListNode

internal class LinkedListCycle2Test {

    @ParameterizedTest
    @MethodSource("args")
    fun detectCycle(input: Array<Int>, loopStart: Int) {
        val head = input.toListNode()
        val expected = head.get(loopStart)
        val actual = Solution.detectCycle(head.loop(loopStart))
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(3, 2, 0, -4), 1),
            Arguments.of(arrayOf(1, 2), 0),
            Arguments.of(arrayOf(1), -1),
        )
    }
}