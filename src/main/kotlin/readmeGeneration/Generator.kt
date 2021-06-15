package readmeGeneration

import org.reflections.Reflections
import java.lang.StringBuilder
import java.util.*

class Generator {
    private data class Solution(
        val problemName: String,
        val difficulty: ProblemDifficulty,
        val link: String,
    )

    companion object {
        fun createReadMe(): String {
            val sb = StringBuilder()
            sb.appendLine("# Solved problems")
            val solutions = getSolutions()

            writeDifficultiesCount(solutions, sb)

            writeSolutionsTable(solutions, sb)

            return sb.toString()
        }

        private fun getSolutions(): List<Solution> {
            val reflections = Reflections("solutions")

            val solutionAnnotations = reflections.getTypesAnnotatedWith(ProblemSolution::class.java)

            return solutionAnnotations
                .map { clazz -> clazz.annotations.single { it is ProblemSolution } as ProblemSolution }
                .sortedBy { it.number }
                .map { Solution("${it.number}. ${it.problemName}", it.difficulty, it.link) }
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
                    if (easyCount > 0) "Easy: $easyCount" else "",
                    if (mediumCount > 0) "Easy: $mediumCount" else "",
                    if (hardCount > 0) "Easy: $hardCount" else "",
                ).filter { it.isNotEmpty() }.joinToString(postfix = System.lineSeparator()))
            }
        }

        private fun writeSolutionsTable(
            solutions: List<Solution>,
            sb: StringBuilder
        ) {
            sb.appendLine("Name | Difficulty")
            sb.appendLine("--- | ---")

            for (s in solutions) {
                sb.appendLine("[${s.problemName}](${s.link}) | ${s.difficulty.name.lowercase().replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }}")
            }
        }
    }
}