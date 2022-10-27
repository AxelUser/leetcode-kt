package problems.imageOverlap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class ImageOverlapTest {

    @ParameterizedTest
    @MethodSource
    fun largestOverlap(img1: Array<Array<Int>>, img2: Array<Array<Int>>, expected: Int) {
        val actual = Solution.largestOverlap(
            img1.map { it.toIntArray() }.toTypedArray(),
            img2.map { it.toIntArray() }.toTypedArray()
        )

        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun largestOverlap() = listOf(
            Arguments.of(
                arrayOf(arrayOf(1, 1, 0), arrayOf(0, 1, 0), arrayOf(0, 1, 0)),
                arrayOf(arrayOf(0, 0, 0), arrayOf(0, 1, 1), arrayOf(0, 0, 1)),
                3
            ),
            Arguments.of(
                arrayOf(arrayOf(1)),
                arrayOf(arrayOf(1)),
                1
            ),
            Arguments.of(
                arrayOf(arrayOf(0)),
                arrayOf(arrayOf(0)),
                0
            )
        )
    }
}