package solutions.rotateList

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import solutions.utils.toArray
import solutions.utils.toListNode
import kotlin.test.assertContentEquals

internal class RotateListTest {

    @ParameterizedTest
    @MethodSource("args")
    fun rotateRight(head: Array<Int>, k: Int, expected: Array<Int>) {
        val actual = Solution().rotateRight(head.toListNode(), k).toArray()
        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(1,2,3,4,5), 2, arrayOf(4,5,1,2,3)),
            Arguments.of(arrayOf(0,1,2), 4, arrayOf(2,0,1)),
            Arguments.of(arrayOf(0,1,2), 1, arrayOf(2,0,1)),
            Arguments.of(arrayOf(0,1,2), 0, arrayOf(0,1,2)),
            Arguments.of(arrayOf(1,2,3), 1, arrayOf(3,1,2)),
            Arguments.of(arrayOf(1,2), 1, arrayOf(2,1)),
            Arguments.of(emptyArray<Int>(), 4, emptyArray<Int>()),
            Arguments.of(arrayOf(1), 4, arrayOf(1)),
        )
    }
}