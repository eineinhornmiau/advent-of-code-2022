fun main() {
    fun part1(input: List<String>): Int {
        var highest = 0
        var temp = 0

        for (line in input) {
            if (line == "") {
                highest = highest.coerceAtLeast(temp)
                temp = 0
                continue
            }

            temp += line.toInt()
        }

        return highest
    }

    fun part2(input: List<String>): Int {
        val elves: MutableList<Int> = mutableListOf()
        var temp = 0

        for (i in input.indices) {
            if (input[i] != "") {
                temp += input[i].toInt()
            }

            if (input[i] == "" || i == input.indices.last) {
                elves.add(temp)
                temp = 0
                continue
            }
        }

        elves.sortDescending()

        return elves[0] + elves[1] + elves[2]
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
