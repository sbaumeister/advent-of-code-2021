fun main() {
    fun part1(input: List<String>): Int {
        var x = 0
        var y = 0
        input.forEach {
            val command = it.split(" ")
            val value = command[1].toInt()
            when (command[0]) {
                "forward" -> x += value
                "down" -> y += value
                "up" -> y -= value
            }
        }
        return x * y
    }

    fun part2(input: List<String>): Int {
        var x = 0
        var y = 0
        var a = 0
        input.forEach {
            val command = it.split(" ")
            val value = command[1].toInt()
            when (command[0]) {
                "forward" -> {
                    x += value
                    y += value * a
                }
                "down" -> a += value
                "up" -> a -= value
            }
        }
        return x * y
    }

    val input = readLines("Day02.txt")
    println(part1(input))
    println(part2(input))
}
