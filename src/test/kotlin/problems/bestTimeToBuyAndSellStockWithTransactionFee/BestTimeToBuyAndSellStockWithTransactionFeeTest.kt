package problems.bestTimeToBuyAndSellStockWithTransactionFee

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BestTimeToBuyAndSellStockWithTransactionFeeTest {

    @ParameterizedTest
    @MethodSource
    fun maxProfit(prices: IntArray, fee: Int, expected: Int) {
        val actual = Solution().maxProfit(prices, fee)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun maxProfit() = listOf(
            Arguments.of(intArrayOf(1, 3, 2, 8, 4, 9), 2, 8),
            Arguments.of(intArrayOf(1, 3, 7, 5, 10, 3), 3, 6),
        )
    }
}