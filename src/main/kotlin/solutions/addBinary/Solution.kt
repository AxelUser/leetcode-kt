package solutions.addBinary

import readmeGeneration.ProblemDifficulty
import readmeGeneration.ProblemSolution

@ProblemSolution(67, "Add Binary", ProblemDifficulty.EASY, "https://leetcode.com/problems/add-binary/")
class Solution {
    fun addBinary(a: String, b: String): String {
        val sb = StringBuilder()
        var i = a.length - 1
        var j = b.length - 1
        var sum = 0
        while (i >= 0 || j >= 0) {
            if (i >= 0) sum += a[i--] - '0'
            if (j >= 0) sum += b[j--] - '0'
            sb.append(sum % 2)
            sum /= 2
        }

        if (sum > 0) sb.append(sum)

        return sb.reverse().toString()
    }
}