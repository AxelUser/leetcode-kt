package utils

fun parseInt2DArray(string: String): Array<Array<Int>> {
    val rowRegex = Regex("\\[[-\\d+,]+]")
    val numRegex = Regex("-?\\d+")
    val matrix = mutableListOf<Array<Int>>()

    for (row in rowRegex.findAll(string).map { it.value }) {
        matrix.add(numRegex.findAll(row).map { it.value.toInt() }.toList().toTypedArray())
    }

    return matrix.toTypedArray()
}