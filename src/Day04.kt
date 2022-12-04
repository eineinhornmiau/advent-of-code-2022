fun IntRange.contains(range: IntRange): Boolean {
    return this.first <= range.first && this.last >= range.last
}

fun IntRange.overlaps(range: IntRange): Boolean {
    for (i in this) {
        if (range.contains(i)) {
            return true
        }
    }

    return false
}

fun main() {
    fun part1(input: List<String>): Int {
        var sames = 0
        for (line in input) {
            val firstElve = line.substringBefore(',')
            val secondElve = line.substringAfter(',')

            val firstRange = firstElve.substringBefore("-").toInt()..firstElve.substringAfter("-").toInt()
            val secondRange = secondElve.substringBefore("-").toInt()..secondElve.substringAfter("-").toInt()

            if (firstRange.contains(secondRange) || secondRange.contains(firstRange)) {
                sames++
                continue
            }
        }
        return sames
    }

    fun part2(input: List<String>): Int {
        var overlaps = 0
        for (line in input) {
            val firstElve = line.substringBefore(',')
            val secondElve = line.substringAfter(',')

            val firstRange = firstElve.substringBefore("-").toInt()..firstElve.substringAfter("-").toInt()
            val secondRange = secondElve.substringBefore("-").toInt()..secondElve.substringAfter("-").toInt()

            if (firstRange.overlaps(secondRange)) {
                overlaps++
            }
        }
        return overlaps
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
