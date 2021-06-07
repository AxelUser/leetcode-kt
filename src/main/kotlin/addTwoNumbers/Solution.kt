package addTwoNumbers

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val root: ListNode?

        // init result
        val initSum = l1?.`val`!! + l2?.`val`!!
        root = ListNode(initSum % 10)
        if(initSum / 10 > 0) {
            root.next = ListNode(1)
        }

        var n1 = l1.next
        var n2 = l2.next
        var parent = root

        while (n1 != null || n2 != null) {
            if (parent?.next == null) {
                val sum = (n1?.`val` ?: 0) + (n2?.`val` ?: 0)

                val cur = ListNode(sum % 10)

                if (sum / 10 > 0) {
                    cur.next = ListNode(1)
                }

                parent?.next = cur
            } else {
                val sum = parent.next!!.`val` + (n1?.`val` ?: 0) + (n2?.`val` ?: 0)

                val cur = ListNode(sum % 10)
                if(sum / 10 > 0) {
                    cur.next = ListNode(1)
                }

                parent.next = cur
            }

            n1 = n1?.next
            n2 = n2?.next
            parent = parent?.next
        }

        return root
    }
}