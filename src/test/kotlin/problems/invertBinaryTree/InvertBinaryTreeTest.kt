package problems.invertBinaryTree

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.toArrayBfs
import utils.toBinaryTreeBfs
import kotlin.test.assertContentEquals

internal class InvertBinaryTreeTest {

    @ParameterizedTest
    @MethodSource
    fun invertTree(input: Array<Int?>, expected: Array<Int?>) {
        val actual = Solution.invertTree(input.toBinaryTreeBfs())
        assertContentEquals(expected, actual.toArrayBfs())
    }

    companion object {
        @JvmStatic
        fun invertTree() = listOf(
            Arguments.of(arrayOf<Int?>(4, 2, 7, 1, 3, 6, 9), arrayOf<Int?>(4, 7, 2, 9, 6, 3, 1)),
            Arguments.of(arrayOf<Int?>(2, 1, 3), arrayOf<Int?>(2, 3, 1)),
            Arguments.of(arrayOf<Int?>(2, 1, null), arrayOf<Int?>(2, null, 1)),
            Arguments.of(arrayOf<Int?>(), arrayOf<Int?>()),
        )
    }
}