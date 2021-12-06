fun main() {
    fun part1(input: List<String>): Int {

        val grid = Array(1000) { IntArray(1000) { 0 } }

        input.forEach {
            val (xs1, ys1, xs2, ys2) = """(\d+),(\d+) -> (\d+),(\d+)""".toRegex().find(it)!!.destructured
            val x1 = xs1.toInt()
            val y1 = ys1.toInt()
            val x2 = xs2.toInt()
            val y2 = ys2.toInt()

            // vertical line
            if (x1 == x2) {
                val (ry1, ry2) = listOf(y1, y2).sorted()
                for (i in ry1..ry2) {
                    grid[x1][i] += 1
                }
            } else
            // horizontal line
            if (y1 == y2) {
                val (rx1, rx2) = listOf(x1, x2).sorted()
                for (i in rx1..rx2) {
                    grid[i][y1] += 1
                }
            }
        }

        return grid.flatMap { it.toList() }.sumBy { if (it >= 2) 1 else 0 }
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = readLines("Day05.txt")
    println(part1(input))
    println(part2(input))
}
