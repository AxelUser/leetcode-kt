package problems.sameTree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.toBinaryTreeBfs

internal class SameTreeTest {

    @ParameterizedTest
    @MethodSource
    fun isSameTree(p: Array<Int?>, q: Array<Int?>, expected: Boolean) {
        val actual = Solution.isSameTree(p.toBinaryTreeBfs(), q.toBinaryTreeBfs())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun isSameTree() = listOf(
            Arguments.of(arrayOf<Int?>(1, 2, 3), arrayOf<Int?>(1, 2, 3), true),
            Arguments.of(arrayOf<Int?>(1, 2), arrayOf<Int?>(1, null, 2), false),
            Arguments.of(arrayOf<Int?>(1, 2, 1), arrayOf<Int?>(1, 1, 2), false),
        )
    }
}