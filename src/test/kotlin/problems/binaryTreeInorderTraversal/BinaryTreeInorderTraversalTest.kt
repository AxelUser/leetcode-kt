package problems.binaryTreeInorderTraversal

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.toBinaryTreeBfs
import kotlin.test.assertContentEquals

internal class BinaryTreeInorderTraversalTest {

    @ParameterizedTest
    @MethodSource
    fun inorderTraversal(input: Array<Int?>, expected: List<Int>) {
        val actual = Solution.inorderTraversal(input.toBinaryTreeBfs())
        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun inorderTraversal() = listOf(
            Arguments.of(arrayOf(1, null, 2, 3), listOf(1, 3, 2)),
            Arguments.of(arrayOf<Int?>(), listOf<Int>()),
            Arguments.of(arrayOf<Int?>(1), listOf<Int>(1)),
            Arguments.of(arrayOf<Int?>(1, 2, 3, 4, 5, null, 6), listOf<Int>(4, 2, 5, 1, 3, 6)),
        )
    }
}