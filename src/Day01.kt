fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readLines("Day01_test.txt")
    check(part1(testInput) == 1)

    val input = readLines("Day01.txt")
    println(part1(input))
    println(part2(input))
}
