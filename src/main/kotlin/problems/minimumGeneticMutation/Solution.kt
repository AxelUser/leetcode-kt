package problems.minimumGeneticMutation

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution
import java.util.*

@ProblemSolution(
    433,
    "Minimum Genetic Mutation",
    ProblemDifficulty.MEDIUM,
    "https://leetcode.com/problems/minimum-genetic-mutation/"
)
object Solution {
    // power of base = 5
    private val pows = arrayOf(1, 5, 25, 125, 625, 3125, 15625, 78125)

    private val codes = charArrayOf('A', 'C', 'G', 'T')

    private fun Char.idx(): Int {
        return when (this) {
            'A' -> 1
            'C' -> 2
            'G' -> 3
            'T' -> 4
            else -> error("unexpected")
        }
    }

    private fun String.hash(): Int {
        var hash = 0
        repeat(8) {
            hash += this[it].idx() * pows[it]
        }
        return hash
    }

    fun minMutation(start: String, end: String, bank: Array<String>): Int {
        val bHs = bank.map { it.hash() }
        val eHs = end.hash()
        val queue: Queue<Pair<String, Int>> = LinkedList()
        val seen = mutableSetOf<Int>()
        with(start.hash()) {
            queue.add(start to this)
            seen.add(this)
        }

        var count = 0
        while (!queue.isEmpty()) {
            repeat(queue.size) {
                val (n, nHs) = queue.poll()
                if (nHs == eHs) {
                    return count
                }
                for (c in codes) {
                    val cIdx = c.idx()
                    for (i in n.indices) {
                        if (c == n[i]) continue
                        val cHs = cIdx * pows[i]
                        val hash = nHs - (n[i].idx() * pows[i]) + cHs
                        if (!seen.contains(hash)) {
                            val bIdx = bHs.indexOf(hash)
                            if (bIdx != -1) {
                                queue.add(bank[bIdx] to hash)
                                seen.add(hash)
                            }
                        }
                    }
                }
            }
            count++
        }
        return -1
    }
}