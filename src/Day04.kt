fun main() {

    fun part1(input: List<String>): Int {
        var sames = 0
        for (line in input) {
            val firstElve = line.substringBefore(',')
            val secondElve = line.substringAfter(',')

            val firstRange = firstElve.substringBefore("-").toInt()..firstElve.substringAfter("-").toInt()
            val secondRange = secondElve.substringBefore("-").toInt()..secondElve.substringAfter("-").toInt()

            if (firstRange.first <= secondRange.first && firstRange.last >= secondRange.last) {
                sames++
                continue
            }

            if (secondRange.first <= firstRange.first && secondRange.last >= firstRange.last) {
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

            for (i in firstRange) {
                if (secondRange.contains(i)) {
                    overlaps++
                    break
                }
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
