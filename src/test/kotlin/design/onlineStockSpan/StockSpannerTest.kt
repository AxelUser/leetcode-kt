package design.onlineStockSpan

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class StockSpannerTest {

    @Test
    fun `next should return valid number of days`() {
        val spanner = StockSpanner()

        assertEquals(1, spanner.next(100))
        assertEquals(1, spanner.next(80))
        assertEquals(1, spanner.next(60))
        assertEquals(2, spanner.next(70))
        assertEquals(1, spanner.next(60))
        assertEquals(4, spanner.next(75))
        assertEquals(6, spanner.next(85))
    }
}