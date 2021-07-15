package solutions.decodeString

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

internal class DecodeStringTest {

    @ParameterizedTest
    @MethodSource
    fun decodeString(s: String, expected: String) {
        assertEquals(expected, Solution().decodeString(s))
    }

    companion object {
        @JvmStatic
        fun decodeString() = listOf(
            Arguments.of("3[a]2[bc]", "aaabcbc"),
            Arguments.of("3[a2[c]]", "accaccacc"),
            Arguments.of("2[abc]3[cd]ef", "abcabccdcdcdef"),
            Arguments.of("abc3[cd]xyz", "abccdcdcdxyz"),
        )
    }
}