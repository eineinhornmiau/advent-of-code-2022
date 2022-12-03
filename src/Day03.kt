fun main() {
    fun part1(input: List<String>): Int {
        var result = 0

        for (rucksack in input) {
            val first = rucksack.substring(0 until rucksack.length / 2)
            val second = rucksack.substring(rucksack.length / 2)

            val sameItems = first.filter { c -> second.contains(c) }

            val sameChar = sameItems[0]

            val sameCharCode = if (sameChar.category == CharCategory.LOWERCASE_LETTER) {
                sameChar.code - 96
            } else {
                sameChar.code - 38
            }

            result += sameCharCode
        }

        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0

        for (i in input.indices step 3) {
            val first = input[i]
            val second = input[i + 1]
            val third = input[i + 2]

            val sameItems = first.filter { c -> second.contains(c) && third.contains(c) }

            val sameChar = sameItems[0]

            val sameCharCode = if (sameChar.category == CharCategory.LOWERCASE_LETTER) {
                sameChar.code - 96
            } else {
                sameChar.code - 38
            }

            result += sameCharCode
        }

        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
