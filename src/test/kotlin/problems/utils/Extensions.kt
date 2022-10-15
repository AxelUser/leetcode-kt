package problems.utils

import problems.common.ListNode

fun Array<Int>.toListNode(): ListNode? {
    var root: ListNode? = null
    var cur: ListNode? = null
    for (dig in this) {
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

fun ListNode?.get(index: Int): ListNode? {
    var count = 0
    var cur = this
    while (cur != null) {
        if (index == count++) return cur
        cur = cur.next
    }

    return null
}

fun ListNode?.toArray(): Array<Int> {
    if (this == null) {
        return arrayOf()
    }

    val list = mutableListOf<Int>()
    var cur: ListNode? = this
    while (cur != null) {
        list.add(cur.`val`)
        cur = cur.next
    }

    return list.toTypedArray()
}

fun Array<CharArray>.stringifyMatrix(): String = this.joinToString(separator = "", prefix = System.lineSeparator()) {
    it.joinToString(
        prefix = "\t",
        postfix = System.lineSeparator()
    )
}

fun Array<IntArray>.stringifyMatrix(): String = this.joinToString(separator = "", prefix = System.lineSeparator()) {
    it.joinToString(
        prefix = "\t",
        postfix = System.lineSeparator()
    )
}

fun <T> Array<Array<T>>.stringifyMatrix(): String = this.joinToString(separator = "", prefix = System.lineSeparator()) {
    it.joinToString(
        prefix = "\t",
        postfix = System.lineSeparator()
    )
}