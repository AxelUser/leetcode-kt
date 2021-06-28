package solutions.bestTimeToBuyAndSellStock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BestTimeToBuyAndSellStockTest {

    @ParameterizedTest
    @MethodSource
    fun maxProfit(prices: IntArray, expected: Int) {
        assertEquals(expected, Solution().maxProfit(prices))
    }

    companion object {
        @JvmStatic
        fun maxProfit() = listOf(
            Arguments.of(arrayOf(7,1,5,3,6,4).toIntArray(), 5),
            Arguments.of(arrayOf(7,6,4,3,1).toIntArray(), 0),
        )
    }
}