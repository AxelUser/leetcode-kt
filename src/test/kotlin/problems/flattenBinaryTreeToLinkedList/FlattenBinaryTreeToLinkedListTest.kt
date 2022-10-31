package problems.flattenBinaryTreeToLinkedList

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.toArrayBfs
import utils.toBinaryTreeBfs
import kotlin.test.assertContentEquals

internal class FlattenBinaryTreeToLinkedListTest {

    @ParameterizedTest
    @MethodSource("args")
    fun flatten(input: Array<Int?>, expected: Array<Int?>) {
        val actual = input.toBinaryTreeBfs()
        Solution.flatten(actual)
        assertContentEquals(expected, actual.toArrayBfs())
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(1, 2, 5, 3, 4, null, 6), arrayOf(1, null, 2, null, 3, null, 4, null, 5, null, 6)),
            Arguments.of(emptyArray<Int?>(), emptyArray<Int?>()),
            Arguments.of(arrayOf<Int?>(0), arrayOf<Int?>(0))
        )
    }
}