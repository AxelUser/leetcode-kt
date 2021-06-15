package solutions.threeSum

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

internal class ThreeSumTest {

    @ParameterizedTest
    @MethodSource
    fun threeSum(nums: IntArray, expected: List<List<Int>>) {
        val sut = Solution()
        val actual = sut.threeSum(nums)

        assertEquals(expected.size, actual.size)
        assertTuplesEquals(expected, actual)
    }

    private fun assertTuplesEquals(expected: List<List<Int>>, actual: List<List<Int>>){
        var i = 0
        var j = 0

        while (i < expected.size && j < actual.size) {
            assertContentEquals(expected[i++], actual[j++])
        }
    }

    companion object {
        @JvmStatic
        fun threeSum() = listOf(
            Arguments.of(arrayOf(-1, 0, 1, 2, -1, -4).toIntArray(), listOf(listOf(-1, -1, 2), listOf(-1, 0, 1))),
            //Arguments.of(emptyArray<Int>().toIntArray(), emptyList<List<Int>>()),
            //Arguments.of(arrayOf(0).toIntArray(), emptyList<List<Int>>()),
        )
    }
}