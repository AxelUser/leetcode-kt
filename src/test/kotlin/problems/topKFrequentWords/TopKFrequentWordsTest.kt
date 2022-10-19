package problems.topKFrequentWords

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class TopKFrequentWordsTest {

    @ParameterizedTest
    @MethodSource("args")
    fun topKFrequent(words: Array<String>, k: Int, expected: Array<String>) {
        val actual = Solution.topKFrequent(words, k).toTypedArray()
        assertContentEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2, arrayOf("i", "love")),
            Arguments.of(
                arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"),
                4,
                arrayOf("the", "is", "sunny", "day")
            ),
        )
    }
}