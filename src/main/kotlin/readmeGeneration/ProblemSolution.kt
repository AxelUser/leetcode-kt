package readmeGeneration

@Target(AnnotationTarget.CLASS)
annotation class ProblemSolution(
    val number: Int,
    val problemName: String,
    val difficulty: ProblemDifficulty,
    val link: String,
)
