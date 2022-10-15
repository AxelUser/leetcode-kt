package problems.symmetricTree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import problems.utils.toBinaryTreeBfs

internal class SymmetricTreeTest {

    @ParameterizedTest
    @MethodSource("args")
    fun isSymmetric(input: Array<Int?>, expected: Boolean) {
        val actual = Solution.isSymmetric(input.toBinaryTreeBfs())
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf<Int?>(1, 2, 2, 3, 4, 4, 3), true),
            Arguments.of(arrayOf(1, 2, 2, null, 3, null, 3), false),
            Arguments.of(arrayOf<Int?>(1), true),
        )
    }
}