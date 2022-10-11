package problems.coinChange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CoinChangeTest {

    @ParameterizedTest
    @MethodSource("args")
    fun coinChange(coins: IntArray, amount: Int, expected: Int) {
        val actual = Solution().coinChange(coins, amount)

        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun args() = listOf(
            Arguments.of(arrayOf(1,2,5).toIntArray(), 11, 3),
            Arguments.of(arrayOf(2).toIntArray(), 3, -1),
            Arguments.of(arrayOf(1).toIntArray(), 0, 0),
        )
    }
}