package addTwoNumbers

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertContentEquals

internal class AddTwoNumbersTest {

    var sut = Solution()

    @ParameterizedTest
    @MethodSource
    fun addTwoNumbers(l1: Array<Int>, l2: Array<Int>, expected: Array<Int>) {
        val actual = sut.addTwoNumbers(arrayToListNode(l1), arrayToListNode(l2))

        assertContentEquals(expected, listNodeToArray(actual))
    }


    companion object {
        @JvmStatic
        fun addTwoNumbers() = listOf(
            Arguments.of(arrayOf(2,4,3), arrayOf(5,6,4), arrayOf(7,0,8)),
            Arguments.of(arrayOf(0), arrayOf(0), arrayOf(0)),
            Arguments.of(arrayOf(9,9,9,9,9,9,9), arrayOf(9,9,9,9), arrayOf(8,9,9,9,0,0,0,1)),
        )

        private fun arrayToListNode(arr: Array<Int>): ListNode? {
            var root: ListNode? = null
            var cur: ListNode? = null
            for (dig in arr) {
                if(root == null) {
                    root = ListNode(dig)
                    cur = root
                } else {
                    cur?.next = ListNode(dig)
                    cur = cur?.next
                }
            }

            return root
        }

        private fun listNodeToArray(root: ListNode?): Array<Int> {
            if (root == null) {
                return arrayOf()
            }

            val list = mutableListOf<Int>()
            var cur: ListNode? = root
            while (cur != null) {
                list.add(cur.`val`)
                cur = cur.next
            }

            return list.toTypedArray()
        }
    }
}