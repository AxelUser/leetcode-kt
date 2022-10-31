package problems.constructBinaryTreeFromPreorderAndInorderTraversal

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.toArrayBfs
import kotlin.test.assertContentEquals

internal class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    @ParameterizedTest
    @MethodSource("args")
    fun buildTree(preorder: Array<Int>, inorder: Array<Int>, expected: Array<Int?>) {
        val actual = Solution.buildTree(preorder.toIntArray(), inorder.toIntArray())
        assertContentEquals(expected, actual.toArrayBfs())
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(3, 9, 20, 15, 7), arrayOf(9, 3, 15, 20, 7), arrayOf(3, 9, 20, null, null, 15, 7))
        )
    }
}