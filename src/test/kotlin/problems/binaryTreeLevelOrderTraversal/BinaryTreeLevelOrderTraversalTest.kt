package problems.binaryTreeLevelOrderTraversal

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.parseInt2DArray
import problems.utils.stringify2DArray
import problems.utils.toBinaryTreeBfs

internal class BinaryTreeLevelOrderTraversalTest {

    @ParameterizedTest
    @MethodSource("args")
    fun levelOrder(input: Array<Int?>, expected: Array<Array<Int>>) {
        val actual = Solution.levelOrder(input.toBinaryTreeBfs()).map { it.toTypedArray() }.toTypedArray()
        assertEquals(expected.stringify2DArray(), actual.stringify2DArray())
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(3, 9, 20, null, null, 15, 7), parseInt2DArray("[[3],[9,20],[15,7]]")),
            Arguments.of(arrayOf<Int?>(1), parseInt2DArray("[[1]]")),
            Arguments.of(arrayOf<Int?>(), parseInt2DArray("[]")),
        )
    }
}