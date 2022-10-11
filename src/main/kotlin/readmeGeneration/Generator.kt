package readmeGeneration

import org.reflections.Reflections
import java.lang.StringBuilder
import java.util.*

class Generator {
    private data class Solution(
        val number: Int,
        val problemName: String,
        val difficulty: ProblemDifficulty,
        val link: String,
        val solution: String
    )

    companion object {
        fun createReadMe(): String {
            val sb = StringBuilder()
            sb.appendLine("# Solved problems")
            sb.appendLine("> LeetCode problems solved in Kotlin.")
            sb.appendLine()
            val solutions = getSolutions()

            writeDifficultiesCount(solutions, sb)

            writeSolutionsTable(solutions, sb)

            return sb.toString()
        }

        private fun getSolutions(): List<Solution> {
            val reflections = Reflections("problems", "design")

            val solutionAnnotations = reflections.getTypesAnnotatedWith(ProblemSolution::class.java)

            return solutionAnnotations
                .map { clazz ->
                    val a = clazz.annotations.single { it is ProblemSolution } as ProblemSolution
                    Solution(a.number, a.problemName, a.difficulty, a.link, "src/main/kotlin/" + clazz.canonicalName.replace('.', '/') + ".kt")
                }
                .sortedBy { it.number }
        }

        private fun writeDifficultiesCount(
            solutions: List<Solution>,
            sb: StringBuilder
        ) {
            val easyCount = solutions.count { it.difficulty == ProblemDifficulty.EASY }
            val mediumCount = solutions.count { it.difficulty == ProblemDifficulty.MEDIUM }
            val hardCount = solutions.count { it.difficulty == ProblemDifficulty.HARD }

            if (easyCount > 0 || mediumCount > 0 || hardCount > 0) {
                sb.appendLine(arrayOf(
                    "Total: ${easyCount + mediumCount + hardCount}",
                    if (easyCount > 0) "Easy: $easyCount" else "",
                    if (mediumCount > 0) "Medium: $mediumCount" else "",
                    if (hardCount > 0) "Hard: $hardCount" else "",
                ).filter { it.isNotEmpty() }.joinToString(postfix = '.' + System.lineSeparator()))
            }
        }

        private fun writeSolutionsTable(
            solutions: List<Solution>,
            sb: StringBuilder
        ) {
            sb.appendLine("| Name | Difficulty | Solution |")
            sb.appendLine("| --- | --- | --- |")

            for (s in solutions) {
                sb.appendLine("| [${s.number}. ${s.problemName}](${s.link}) | ${s.difficulty.name.lowercase().replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }} | [Source](${s.solution}) |")
            }
        }
    }
}