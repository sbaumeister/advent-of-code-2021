fun main() {
    fun part1(input: List<Int>): Int {
        var countIncrease = 0
        input.indices.forEach {
            if (it > 0 && input[it] - input[it - 1] > 0) {
                countIncrease++
            }
        }
        return countIncrease
    }

    fun part2(input: List<Int>): Int {
        var countIncrease = 0
        input.indices.forEach {
            if (it + 3 < input.size &&
                input[it] + input[it + 1] + input[it + 2] < input[it + 1] + input[it + 2] + input[it + 3]) {
                countIncrease++
            }
        }
        return countIncrease
    }

    val input = readLines("Day01.txt").map { it.toInt() }
    println(part1(input))
    println(part2(input))
}
