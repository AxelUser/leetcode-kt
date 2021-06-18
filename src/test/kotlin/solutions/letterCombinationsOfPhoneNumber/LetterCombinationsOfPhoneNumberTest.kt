package solutions.letterCombinationsOfPhoneNumber

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class LetterCombinationsOfPhoneNumberTest {

    @ParameterizedTest
    @MethodSource
    fun letterCombinations(digits: String, expected: List<String>) {
        assertContentEquals(expected, Solution().letterCombinations(digits))
    }

    companion object {
        @JvmStatic
        fun letterCombinations() = listOf(
            Arguments.of("23", listOf("ad","ae","af","bd","be","bf","cd","ce","cf")),
            Arguments.of("", listOf<String>()),
            Arguments.of("2", listOf("a","b","c")),
        )
    }
}