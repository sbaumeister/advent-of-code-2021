fun main() {
    fun part1(numbers: List<Int>, boards: List<Board>): Int {
        var lastMarkedNumber = 0
        var bingoBoard: Board? = null
        stop@ for (n in numbers) {
            for (board in boards) {
                for ((i, row) in board.withIndex()) {
                    var isRowMarked = true
                    var isColumnMarked = true
                    row.forEachIndexed { j, value ->
                        if (n == value.first) {
                            board[i][j] = value.first to true
                        }
                        if (board[i][j].second.not()) isRowMarked = false
                        if (board[j][i].second.not()) isColumnMarked = false
                    }

                    if (isRowMarked || isColumnMarked) {
                        lastMarkedNumber = n
                        bingoBoard = board
                        break@stop
                    }
                }
            }
        }
        val sumUnmarked = bingoBoard?.flatten()?.filter { it.second.not() }?.fold(0) { acc, num -> acc + num.first }
        return lastMarkedNumber * (sumUnmarked ?: 0)
    }

    fun part2(numbers: List<Int>, boards: List<Board>): Int {
        var lastMarkedNumber = 0
        var lastBingoBoard: List<Pair<Int, Boolean>> = emptyList()
        val bingoBoards = mutableSetOf<Board>()
        for (n in numbers) {
            for (board in boards) {
                for ((i, row) in board.withIndex()) {
                    var isRowMarked = true
                    var isColumnMarked = true
                    row.forEachIndexed { j, value ->
                        if (n == value.first) {
                            board[i][j] = value.first to true
                        }
                        if (board[i][j].second.not()) isRowMarked = false
                        if (board[j][i].second.not()) isColumnMarked = false
                    }

                    if (isRowMarked || isColumnMarked) {
                        if (bingoBoards.contains(board).not()) {
                            lastMarkedNumber = n
                            lastBingoBoard = board.flatten()
                            bingoBoards.add(board)
                        }
                    }
                }
            }
        }
        val sumUnmarked = lastBingoBoard.filter { it.second.not() }.fold(0) { acc, num -> acc + num.first }
        return lastMarkedNumber * sumUnmarked
    }

    fun createBoards(input: List<String>): List<Board> {
        val boards = mutableListOf<Board>()
        var l = 2
        while (l < input.size - 1) {
            val board = Board(5) { i ->
                val lineValues = input[i + l].trim().split("""\s+""".toRegex()).map { it.toInt() }
                Array(5) { j -> lineValues[j] to false }
            }
            boards.add(board)
            l += 6
        }
        return boards
    }

    val input = readLines("Day04.txt")
    val numbers = input.first().split(",").map { it.toInt() }

    println(part1(numbers, createBoards(input)))
    println(part2(numbers, createBoards(input)))
}

typealias Board = Array<Array<Pair<Int, Boolean>>>
