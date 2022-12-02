import GameObject.*

enum class GameObject(val points: Int) { ROCK(1), PAPER(2), SCISSORS(3) }

enum class Move(val gameObject: GameObject) {
    A(ROCK), X(ROCK), B(PAPER), Y(PAPER), C(SCISSORS), Z(
        SCISSORS
    )
}

enum class Outcome(val points: Int) { LOSE(0), DRAW(3), WIN(6) }
enum class Outcome2(val outcome: Outcome) { X(Outcome.LOSE), Y(Outcome.DRAW), Z(Outcome.WIN) }

data class Round(val opponent: GameObject, val me: GameObject)
data class Round2(val opponent: GameObject, val outcome: Outcome)

fun main() {
    fun part1(input: List<String>): Int {
        val rounds = mutableListOf<Round>()

        for (round in input) {
            rounds.add(
                Round(
                    Move.valueOf(round.substringBefore(" ")).gameObject,
                    Move.valueOf(round.substringAfter(" ")).gameObject
                )
            )
        }

        var score = 0

        for ((opponent, me) in rounds) {
            score += me.points
            score += when (me) {
                ROCK -> when (opponent) {
                    PAPER -> Outcome.LOSE.points
                    SCISSORS -> Outcome.WIN.points
                    ROCK -> Outcome.DRAW.points
                }

                PAPER -> when (opponent) {
                    ROCK -> Outcome.WIN.points
                    SCISSORS -> Outcome.LOSE.points
                    PAPER -> Outcome.DRAW.points
                }

                SCISSORS -> when (opponent) {
                    ROCK -> Outcome.LOSE.points
                    PAPER -> Outcome.WIN.points
                    SCISSORS -> Outcome.DRAW.points
                }
            }
        }

        return score
    }

    fun part2(input: List<String>): Int {
        val rounds = mutableListOf<Round2>()

        for (round in input) {
            rounds.add(
                Round2(
                    Move.valueOf(round.substringBefore(" ")).gameObject,
                    Outcome2.valueOf(round.substringAfter(" ")).outcome
                )
            )
        }

        var score = 0

        for ((opponent, outcome) in rounds) {
            score += outcome.points
            score += when (outcome) {
                Outcome.LOSE -> when (opponent) {
                    ROCK -> SCISSORS.points
                    PAPER -> ROCK.points
                    SCISSORS -> PAPER.points
                }

                Outcome.DRAW -> opponent.points

                Outcome.WIN -> when (opponent) {
                    ROCK -> PAPER.points
                    PAPER -> SCISSORS.points
                    SCISSORS -> ROCK.points
                }
            }
        }

        return score
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
