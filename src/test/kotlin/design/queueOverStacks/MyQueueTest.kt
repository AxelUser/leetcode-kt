package design.queueOverStacks

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MyQueueTest {

    @Test
    fun `push should not throw`() {
        val queue = MyQueue()

        queue.push(1)
    }

    @Test
    fun `pop should return values in correct order`() {
        val queue = MyQueue()
        queue.push(1)
        queue.push(2)

        assertEquals(1, queue.pop())
        assertEquals(2, queue.pop())
    }

    @Test
    fun `peek should not remove element and return first`() {
        val queue = MyQueue()
        queue.push(1)
        queue.push(2)

        assertEquals(1, queue.peek())
        assertEquals(1, queue.peek())
    }

    @Test
    fun `empty should return true if queue is empty`() {
        val queue = MyQueue()

        assertTrue(queue.empty())
    }
}