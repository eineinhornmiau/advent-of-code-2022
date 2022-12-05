import java.util.*

fun main() {
    fun parseInput(input: List<String>): List<Deque<Char>> {
        val stacks = mutableListOf<Deque<Char>>()
        val drawing = input.take(input.indexOf(""))

        val n = drawing.last().trim()[drawing.last().trim().lastIndex].digitToInt()
        repeat(n) {
            stacks.add(ArrayDeque())
        }

        for (line in drawing.dropLast(1)) {
            for ((x, i) in (1..line.length step 4).withIndex()) {
                if (line[i] != ' ') {
                    stacks[x].addLast(line[i])
                }

            }
        }

        return stacks
    }

    fun part1(input: List<String>): String {
        val stacks = parseInput(input)

        val instructions = input.drop(input.indexOf("") + 1)

        for (line in instructions) {
            val quantity = line.split(' ')[1].toInt()
            val from = line.split(' ')[3].toInt()
            val to = line.split(' ')[5].toInt()

            repeat(quantity) {
                stacks[to - 1].push(stacks[from - 1].pop())
            }
        }

        var result = ""

        for (stack in stacks) {
            result += stack.pop()
        }

        return result
    }

    fun part2(input: List<String>): String {
        val stacks = parseInput(input)

        val instructions = input.drop(input.indexOf("") + 1)

        for (line in instructions) {
            val quantity = line.split(' ')[1].toInt()
            val from = line.split(' ')[3].toInt()
            val to = line.split(' ')[5].toInt()

            val elements = stacks[from - 1].take(quantity)

            repeat(quantity) {
                stacks[from - 1].removeFirst()
            }

            for (char in elements.asReversed()) {
                stacks[to - 1].push(char)
            }
        }

        var result = ""

        for (stack in stacks) {
            result += stack.pop()
        }

        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
