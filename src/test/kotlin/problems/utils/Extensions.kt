package problems.utils

import common.ListNode
import common.TreeNode
import java.util.*

fun Array<Int>.toListNode(): ListNode? {
    var root: ListNode? = null
    var cur: ListNode? = null
    for (dig in this) {
        if (root == null) {
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
    if (index < 0) return null
    var count = 0
    var cur = this
    while (cur != null) {
        if (index == count++) return cur
        cur = cur.next
    }

    return null
}

fun ListNode?.tail(): ListNode? {
    if (this == null) return null

    var cur = this
    while (cur?.next != null) {
        cur = cur.next
    }

    return cur
}

fun ListNode?.loop(loopStartPos: Int): ListNode? {
    val loopStart = get(loopStartPos) ?: return this
    val tail = tail() ?: return this
    tail.next = loopStart

    return this
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

fun Array<Int?>.toBinaryTreeBfs(): TreeNode? {
    if (isEmpty() || first() == null) return null

    val root = TreeNode(first()!!)
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    var i = 1
    while (i < size) {
        val node = queue.pop()
        node.left = this[i++]?.let { `val` ->
            TreeNode(`val`).also { queue.add(it) }
        }
        node.right = this[i++]?.let { `val` ->
            TreeNode(`val`).also { queue.add(it) }
        }

    }

    return root
}

fun TreeNode?.toArrayBfs(): Array<Int?> {
    if (this == null) return emptyArray()

    val res = LinkedList<Int?>()
    val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()
    queue.add(this)
    while (queue.isNotEmpty()) {
        val lvlSize = queue.size
        val lvl = ArrayList<Int?>(lvlSize)
        for (i in 0 until lvlSize) {
            val node = queue.poll()
            lvl.add(node?.`val`)
            if (node == null) continue
            queue.add(node.left)
            queue.add(node.right)
        }
        if (lvl.any { it != null }) res.addAll(lvl)
    }

    return res.toTypedArray()
}

fun Array<CharArray>.stringify2DArray(): String = this.joinToString(separator = "", prefix = System.lineSeparator()) {
    it.joinToString(
        prefix = "\t",
        postfix = System.lineSeparator()
    )
}

fun Array<IntArray>.stringify2DArray(): String = this.joinToString(separator = "", prefix = System.lineSeparator()) {
    it.joinToString(
        prefix = "\t",
        postfix = System.lineSeparator()
    )
}

fun <T> Array<Array<T>>.stringify2DArray(): String =
    this.joinToString(separator = "", prefix = System.lineSeparator()) {
        it.joinToString(
            prefix = "\t",
            postfix = System.lineSeparator()
        )
    }