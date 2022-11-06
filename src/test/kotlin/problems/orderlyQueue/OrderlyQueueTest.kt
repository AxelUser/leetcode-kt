package problems.orderlyQueue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class OrderlyQueueTest {

    @ParameterizedTest
    @MethodSource
    fun orderlyQueue(s: String, k: Int, expected: String) {
        val actual = Solution.orderlyQueue(s, k)
        assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun orderlyQueue() = listOf(
            Arguments.of("cba", 1, "acb"),
            Arguments.of("baaca", 3, "aaabc"),
            Arguments.of("baaca", 2, "aaabc"),
        )
    }
}