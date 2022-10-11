package design.stackOverQueues

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MyStackTest {

    @Test
    fun push() {
        val stack = MyStack()
        stack.push(1)
        stack.push(2)
    }

    @Test
    fun pop() {
        val stack = MyStack()
        stack.push(1)
        stack.push(2)

        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())
    }

    @Test
    fun top() {
        val stack = MyStack()
        stack.push(1)
        stack.push(2)

        assertEquals(2, stack.top())
        assertEquals(2, stack.top())
    }

    @Test
    fun empty() {
        val stack = MyStack()
        assertTrue(stack.empty())
    }
}