import readmeGeneration.Generator
import java.io.File

fun main() {
    val readMe = Generator.createReadMe()
    val file = File("ReadMe.md")
    file.writeText(readMe)
}