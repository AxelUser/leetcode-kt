package design.minStack

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class MinStackTest {

    @Test
    fun `push should add elem to stack`() {
        val stack = MinStack()
        stack.push(1)
    }

    @Test
    fun `pop should remove elem from stack`() {
        val stack = MinStack()
        stack.push(1)

        stack.pop()
    }

    @Test
    fun `top should get first element in stack`() {
        val stack = MinStack()
        stack.push(1)
        stack.push(2)

        val actual = stack.top()
        assertEquals(2, actual)
    }

    @Test
    fun `getMin should return min element in stack`() {
        val stack = MinStack()
        stack.push(2)
        stack.push(4)

        val actual = stack.getMin()
        assertEquals(2, actual)
    }
}