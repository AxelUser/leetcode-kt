package problems.pathSum2

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.toBinaryTreeBfs
import kotlin.test.assertContentEquals

internal class PathSum2Test {

    @ParameterizedTest
    @MethodSource
    fun pathSum(input: Array<Int?>, targetSum: Int, expected: List<List<Int>>) {
        val actual = Solution().pathSum(input.toBinaryTreeBfs(), targetSum)
        assertContentEquals(expected.map { it.joinToString() }.sorted(), actual.map { it.joinToString() }.sorted())
    }

    companion object {
        @JvmStatic
        fun pathSum() = listOf(
            /*            Arguments.of(
                            arrayOf<Int?>(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1),
                            22,
                            listOf(listOf(5, 4, 11, 2), listOf(5, 8, 4, 5))
                        ),
                        Arguments.of(
                            arrayOf<Int?>(1,2,3),
                            5,
                            listOf<List<Int>>()
                        ),
                        Arguments.of(
                            arrayOf<Int?>(1,2),
                            0,
                            listOf<List<Int>>()
                        ),*/
            Arguments.of(
                arrayOf<Int?>(-2, null, -3),
                -5,
                listOf(listOf(-2, -3))
            )
        )
    }
}