package longestValidParentheses

import java.lang.Integer.max
import java.util.*

class Solution {
    fun longestValidParentheses(s: String): Int {
        var max = 0
        val stack = Stack<Int>()
        stack.push(-1)

        for ((i, par) in s.withIndex()) {
            if (par == '(') {
                stack.push(i)
            } else {
                if(stack.isNotEmpty()) {
                    stack.pop()
                }

                if(stack.isNotEmpty()) {
                    max = max(max, i - stack.peek())
                } else {
                    stack.push(i)
                }


            }
        }

        return max
    }
}