fun main() {
    fun part1(input: List<String>): Int {
        val line = input[0]

        for (i in 3 until line.length) {
            val chars = mutableListOf<Char>()

            for (y in 3 downTo 0) {
                if (!chars.contains(line[i - y])) {
                    chars.add(line[i - y])
                } else {
                    break
                }
            }

            if (chars.size == 4) {
                return i + 1
            }
        }

        return -1
    }

    fun part2(input: List<String>): Int {
        val line = input[0]

        for (i in 13 until line.length) {
            val chars = mutableListOf<Char>()

            for (y in 13 downTo 0) {
                if (!chars.contains(line[i - y])) {
                    chars.add(line[i - y])
                } else {
                    break
                }
            }

            if (chars.size == 14) {
                return i + 1
            }
        }

        return -1
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 19)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
