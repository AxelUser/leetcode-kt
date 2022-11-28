package problems.bestTimeToBuyAndSellStockWithCooldown

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BestTimeToBuyAndSellStockWithCooldownTest {

    @ParameterizedTest
    @MethodSource
    fun maxProfit(prices: IntArray, expected: Int) {
        val actual = Solution.maxProfit(prices)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun maxProfit() = listOf(
            Arguments.of(intArrayOf(1, 2, 3, 0, 2), 3),
            Arguments.of(intArrayOf(1), 0),
        )
    }
}