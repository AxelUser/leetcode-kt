package addTwoNumbers

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val root = add(null, l1, l2)

        var n1 = l1!!.next
        var n2 = l2!!.next
        var parent = root

        while (n1 != null || n2 != null) {
            parent?.next = add(parent, n1, n2)

            n1 = n1?.next
            n2 = n2?.next
            parent = parent?.next
        }

        return root
    }

    private fun add(parent: ListNode?, n1: ListNode?, n2: ListNode?): ListNode? {
        val sum = (parent?.next?.`val` ?: 0) + (n1?.`val` ?: 0) + (n2?.`val` ?: 0)

        val cur = ListNode(sum % 10)
        if (sum / 10 > 0) {
            cur.next = ListNode(1)
        }

        return cur
    }
}