package problems.addOneRowToTree

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.toArrayBfs
import problems.utils.toBinaryTreeBfs
import kotlin.test.assertContentEquals

internal class AddOneRowToTreeTest {

    @ParameterizedTest
    @MethodSource
    fun addOneRow(array: Array<Int?>, `val`: Int, depth: Int, expected: Array<Int?>) {
        val actual = Solution.addOneRow(array.toBinaryTreeBfs(), `val`, depth).toArrayBfs()
        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun addOneRow() = listOf(
            Arguments.of(arrayOf<Int?>(4, 2, 6, 3, 1, 5), 1, 2, arrayOf(4, 1, 1, 2, null, null, 6, 3, 1, 5)),
            Arguments.of(arrayOf(4, 2, null, 3, 1), 1, 3, arrayOf(4, 2, null, 1, 1, 3, null, null, 1)),
            Arguments.of(arrayOf(1, 2, 3, 4), 5, 4, arrayOf(1, 2, 3, 4, null, null, null, 5, 5)),
        )
    }
}