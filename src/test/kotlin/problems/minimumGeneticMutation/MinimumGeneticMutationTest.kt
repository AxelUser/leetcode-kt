package problems.minimumGeneticMutation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumGeneticMutationTest {

    @ParameterizedTest
    @MethodSource
    fun minMutation(start: String, end: String, bank: Array<String>, expected: Int) {
        val actual = Solution.minMutation(start, end, bank)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun minMutation() = listOf(
            Arguments.of("AACCGGTT", "AACCGGTA", arrayOf("AACCGGTA"), 1),
            Arguments.of("AACCGGTT", "AAACGGTA", arrayOf("AACCGGTA", "AACCGCTA", "AAACGGTA"), 2),
            Arguments.of("AAAAACCC", "AACCCCCC", arrayOf("AAAACCCC", "AAACCCCC", "AACCCCCC"), 3),
        )
    }
}