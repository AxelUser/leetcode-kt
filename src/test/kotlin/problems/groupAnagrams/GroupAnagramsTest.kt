package problems.groupAnagrams

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

internal class GroupAnagramsTest {

    @ParameterizedTest
    @MethodSource("args")
    fun groupAnagrams(strs: Array<String>, expected: List<List<String>>) {
        val actual = Solution().groupAnagrams(strs)

        assertEquals(normalize(expected), normalize(actual))
    }

    private fun normalize(groups: List<List<String>>): String {
        return groups.map { l -> l.sortedBy { str -> str }.joinToString(separator = ",", prefix = "[", postfix = "]") }
            .sortedBy { str -> str }.joinToString(separator = "")
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf("eat","tea","tan","ate","nat","bat"), listOf(listOf("bat"), listOf("nat","tan"), listOf("ate","eat","tea"))),
            Arguments.of(arrayOf(""), listOf(listOf(""))),
            Arguments.of(arrayOf("a"), listOf(listOf("a"))),
        )
    }
}