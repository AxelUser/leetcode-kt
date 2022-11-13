package design.medianFinder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MedianFinderTest {

    @Test
    fun findMedian() {
        val finder = MedianFinder()

        finder.addNum(1)
        finder.addNum(2)
        assertEquals(1.5, finder.findMedian())
        finder.addNum(3)
        assertEquals(2.0, finder.findMedian())
    }
}