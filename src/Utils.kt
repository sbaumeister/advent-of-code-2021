import java.io.File

fun readLines(name: String) = File("src", name).readLines()

fun readText(name: String) = File("src", name).readText()

