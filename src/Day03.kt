import kotlin.math.ceil

fun main() {
    fun part1(input: List<String>): Int {
        var gamma = ""
        var epsilon = ""
        for (i in 0..11) {
            var sum = 0
            input.forEach { sum += it[i].digitToInt() }
            if (sum > input.size / 2) {
                gamma += '1'
                epsilon += '0'
            } else {
                gamma += '0'
                epsilon += '1'
            }
        }
        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>, reverseBit: Boolean = false): Int {
        var numbers = input
        for (i in 0..11) {
            var sum = 0
            numbers.forEach { sum += it[i].digitToInt() }
            val majorityCount = ceil(numbers.size / 2.0).toInt()
            val bitCond = if (reverseBit) sum < majorityCount else sum >= majorityCount
            val filterBit = if (bitCond) '1' else '0'
            numbers = numbers.filter { it[i] == filterBit }
            if (numbers.size == 1) break
        }
        return numbers.first().toInt(2)
    }

    val input = readLines("Day03.txt")
    println(part1(input))
    println(part2(input) * part2(input, true))
}
