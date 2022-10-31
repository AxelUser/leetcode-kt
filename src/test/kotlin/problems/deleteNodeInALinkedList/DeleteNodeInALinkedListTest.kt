package problems.deleteNodeInALinkedList

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.get
import utils.toArray
import utils.toListNode
import kotlin.test.assertContentEquals

internal class DeleteNodeInALinkedListTest {

    @ParameterizedTest
    @MethodSource
    fun deleteNode(input: Array<Int>, node: Int, expected: Array<Int>) {
        val actual = input.toListNode()
        Solution.deleteNode(actual.get(node))

        assertContentEquals(expected, actual.toArray())
    }

    companion object {
        @JvmStatic
        fun deleteNode() = listOf(
            Arguments.of(arrayOf(4, 5, 1, 9), 1, arrayOf(4, 1, 9)),
            Arguments.of(arrayOf(4, 5, 1, 9), 2, arrayOf(4, 5, 9)),
            Arguments.of(arrayOf(4, 5, 1, 9), 0, arrayOf(5, 1, 9)),
            Arguments.of(arrayOf(4, 5), 0, arrayOf(5)),
        )
    }
}