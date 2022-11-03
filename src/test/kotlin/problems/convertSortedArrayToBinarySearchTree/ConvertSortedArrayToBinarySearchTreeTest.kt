package problems.convertSortedArrayToBinarySearchTree

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.toArrayBfs
import kotlin.test.assertContentEquals

internal class ConvertSortedArrayToBinarySearchTreeTest {

    @ParameterizedTest
    @MethodSource
    fun sortedArrayToBST(input: Array<Int>, expected: Array<Int?>) {
        val actual = Solution.sortedArrayToBST(input.toIntArray()).toArrayBfs()
        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun sortedArrayToBST() = listOf(
            Arguments.of(arrayOf(-10, -3, 0, 5, 9), arrayOf(0, -10, 5, null, -3, null, 9)),
            Arguments.of(arrayOf(1, 3), arrayOf(1, null, 3)),
            Arguments.of(arrayOf(1), arrayOf(1)),
        )
    }
}