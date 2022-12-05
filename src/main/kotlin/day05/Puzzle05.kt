package day05

fun main() {

    var exampleStacks = getExampleStacks()
    var inputStacks = getInputStacks()

    part1(EXAMPLE_1, exampleStacks)
    println(topOfStack(exampleStacks) == "CMZ")

    part1(INPUT, inputStacks)
    println(topOfStack(inputStacks) == "HBTMTBSDC")

    exampleStacks = getExampleStacks()
    inputStacks = getInputStacks()

    part2(EXAMPLE_1, exampleStacks)
    println(topOfStack(exampleStacks) == "MCD")

    part2(INPUT, inputStacks)
    println(topOfStack(inputStacks) == "PQTJRSHWS")
}

private fun getInputStacks() = mutableListOf(
    ArrayDeque(listOf("R", "N", "P", "G")),
    ArrayDeque(listOf("T", "J", "B", "L", "C", "S", "V", "H")),
    ArrayDeque(listOf("T", "D", "B", "M", "N", "L")),
    ArrayDeque(listOf("R", "V", "P", "S", "B")),
    ArrayDeque(listOf("G", "C", "Q", "S", "W", "M", "V", "H")),
    ArrayDeque(listOf("W", "Q", "S", "C", "D", "B", "J")),
    ArrayDeque(listOf("F", "Q", "L")),
    ArrayDeque(listOf("W", "M", "H", "T", "D", "L", "F", "V")),
    ArrayDeque(listOf("L", "P", "B", "V", "M", "J", "F"))
)

private fun getExampleStacks() = mutableListOf(
    ArrayDeque(listOf("Z", "N")),
    ArrayDeque(listOf("M", "C", "D")),
    ArrayDeque(listOf("P"))
)

private fun topOfStack(stacks: MutableList<ArrayDeque<String>>) =
    stacks.map { it.last() }.reduce { a, b -> a + b }

private fun part1(
    input: String,
    stacks: MutableList<ArrayDeque<String>>
) {
    input.lines().forEach {
        val parts = it.split(" ")
        val count = parts[1].toInt()
        val from = parts[3].toInt() - 1
        val to = parts[5].toInt() - 1

        val fromStack = stacks[from]
        val toStack = stacks[to]
        for (i in 1..count) {
            val j = fromStack.removeLast()
            toStack.addLast(j)
        }
    }
}

private fun part2(
    input: String,
    stacks: MutableList<ArrayDeque<String>>
) {
    input.lines().forEach {
        val parts = it.split(" ")
        val count = parts[1].toInt()
        val from = parts[3].toInt() - 1
        val to = parts[5].toInt() - 1

        val fromStack = stacks[from]
        val toStack = stacks[to]
        val toMove = mutableListOf<String>()
        for (i in 1..count) {
            val j = fromStack.removeLast()
            toMove.add(0, j)
        }
        toMove.forEach { move -> toStack.addLast(move) }
    }
}

private val EXAMPLE_1 = """
move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
""".trimIndent()
private val INPUT = """
move 3 from 3 to 7
move 4 from 1 to 9
move 5 from 6 to 3
move 6 from 9 to 8
move 2 from 9 to 5
move 4 from 3 to 7
move 1 from 3 to 6
move 3 from 5 to 7
move 1 from 2 to 1
move 4 from 7 to 8
move 17 from 8 to 7
move 1 from 6 to 2
move 2 from 6 to 7
move 1 from 8 to 3
move 2 from 4 to 6
move 3 from 9 to 6
move 5 from 6 to 3
move 5 from 2 to 1
move 9 from 3 to 4
move 20 from 7 to 3
move 7 from 5 to 3
move 6 from 3 to 5
move 4 from 1 to 9
move 4 from 5 to 6
move 2 from 1 to 8
move 2 from 7 to 3
move 3 from 6 to 3
move 2 from 5 to 8
move 2 from 9 to 3
move 1 from 9 to 6
move 2 from 2 to 4
move 26 from 3 to 4
move 28 from 4 to 6
move 8 from 6 to 1
move 4 from 8 to 6
move 1 from 9 to 3
move 2 from 3 to 6
move 1 from 3 to 9
move 26 from 6 to 9
move 2 from 7 to 3
move 5 from 1 to 4
move 1 from 1 to 4
move 1 from 6 to 5
move 1 from 2 to 5
move 2 from 3 to 7
move 2 from 5 to 8
move 10 from 4 to 5
move 1 from 6 to 1
move 1 from 8 to 5
move 2 from 7 to 2
move 4 from 4 to 3
move 4 from 7 to 2
move 2 from 1 to 8
move 12 from 9 to 2
move 5 from 2 to 3
move 3 from 3 to 1
move 1 from 1 to 7
move 6 from 3 to 8
move 1 from 5 to 3
move 10 from 9 to 1
move 7 from 8 to 7
move 1 from 3 to 9
move 7 from 7 to 2
move 3 from 2 to 9
move 6 from 2 to 9
move 5 from 9 to 1
move 7 from 2 to 1
move 21 from 1 to 7
move 2 from 1 to 2
move 5 from 2 to 3
move 2 from 4 to 3
move 10 from 5 to 4
move 11 from 4 to 7
move 5 from 3 to 1
move 1 from 4 to 2
move 2 from 8 to 3
move 7 from 9 to 3
move 3 from 9 to 1
move 9 from 7 to 9
move 1 from 3 to 4
move 3 from 9 to 4
move 5 from 9 to 3
move 4 from 3 to 8
move 22 from 7 to 8
move 10 from 3 to 5
move 1 from 9 to 4
move 8 from 1 to 5
move 3 from 4 to 9
move 1 from 3 to 6
move 2 from 1 to 7
move 1 from 4 to 3
move 1 from 4 to 7
move 1 from 2 to 1
move 1 from 6 to 9
move 1 from 3 to 7
move 1 from 1 to 7
move 4 from 9 to 3
move 22 from 8 to 5
move 37 from 5 to 9
move 37 from 9 to 6
move 3 from 7 to 9
move 2 from 8 to 6
move 1 from 9 to 3
move 2 from 5 to 1
move 1 from 2 to 5
move 7 from 6 to 4
move 18 from 6 to 2
move 1 from 3 to 7
move 1 from 5 to 4
move 1 from 8 to 5
move 9 from 2 to 5
move 3 from 4 to 6
move 2 from 2 to 7
move 5 from 2 to 3
move 1 from 8 to 1
move 1 from 9 to 4
move 2 from 7 to 8
move 7 from 3 to 7
move 3 from 1 to 3
move 1 from 9 to 5
move 17 from 6 to 2
move 12 from 7 to 9
move 1 from 4 to 8
move 1 from 8 to 4
move 4 from 5 to 2
move 2 from 8 to 9
move 3 from 4 to 2
move 3 from 3 to 7
move 2 from 4 to 3
move 8 from 9 to 1
move 1 from 4 to 2
move 24 from 2 to 1
move 6 from 5 to 1
move 1 from 7 to 4
move 3 from 2 to 8
move 3 from 3 to 7
move 1 from 4 to 6
move 2 from 8 to 5
move 3 from 9 to 4
move 1 from 5 to 3
move 1 from 3 to 5
move 3 from 9 to 8
move 1 from 5 to 7
move 5 from 7 to 9
move 2 from 8 to 4
move 1 from 3 to 2
move 1 from 7 to 3
move 1 from 8 to 5
move 1 from 2 to 9
move 1 from 6 to 2
move 2 from 9 to 8
move 1 from 3 to 7
move 24 from 1 to 3
move 1 from 7 to 6
move 3 from 5 to 1
move 1 from 4 to 3
move 1 from 8 to 6
move 1 from 6 to 4
move 1 from 5 to 4
move 1 from 8 to 5
move 1 from 5 to 7
move 1 from 2 to 5
move 1 from 6 to 3
move 1 from 4 to 9
move 1 from 5 to 7
move 2 from 9 to 2
move 3 from 4 to 8
move 2 from 4 to 3
move 11 from 1 to 9
move 7 from 9 to 1
move 9 from 1 to 9
move 1 from 3 to 7
move 3 from 7 to 4
move 2 from 2 to 6
move 2 from 4 to 1
move 1 from 6 to 7
move 22 from 3 to 7
move 1 from 3 to 5
move 1 from 5 to 2
move 1 from 6 to 7
move 5 from 1 to 9
move 1 from 8 to 5
move 1 from 2 to 1
move 15 from 9 to 4
move 6 from 9 to 6
move 14 from 4 to 1
move 5 from 6 to 2
move 1 from 5 to 1
move 9 from 1 to 4
move 5 from 1 to 3
move 3 from 2 to 6
move 2 from 8 to 1
move 5 from 1 to 9
move 10 from 7 to 8
move 3 from 3 to 8
move 2 from 8 to 7
move 5 from 4 to 9
move 3 from 3 to 5
move 1 from 6 to 9
move 1 from 3 to 9
move 1 from 3 to 6
move 1 from 3 to 7
move 2 from 6 to 9
move 2 from 4 to 1
move 13 from 9 to 8
move 2 from 1 to 4
move 6 from 4 to 9
move 1 from 6 to 2
move 1 from 2 to 3
move 3 from 5 to 3
move 4 from 3 to 2
move 7 from 9 to 2
move 1 from 6 to 4
move 4 from 2 to 5
move 2 from 2 to 1
move 4 from 5 to 8
move 1 from 4 to 2
move 6 from 2 to 1
move 2 from 2 to 1
move 22 from 8 to 2
move 16 from 7 to 4
move 14 from 2 to 7
move 7 from 8 to 2
move 4 from 7 to 1
move 14 from 2 to 1
move 10 from 7 to 1
move 1 from 7 to 3
move 1 from 3 to 4
move 1 from 2 to 5
move 25 from 1 to 5
move 1 from 5 to 3
move 4 from 4 to 2
move 13 from 4 to 6
move 4 from 2 to 1
move 3 from 6 to 2
move 9 from 1 to 2
move 22 from 5 to 4
move 1 from 2 to 7
move 8 from 1 to 5
move 1 from 4 to 5
move 15 from 4 to 3
move 11 from 2 to 1
move 1 from 7 to 3
move 2 from 5 to 1
move 13 from 3 to 5
move 10 from 6 to 7
move 1 from 3 to 4
move 1 from 3 to 6
move 1 from 3 to 9
move 1 from 9 to 5
move 1 from 6 to 2
move 6 from 4 to 9
move 1 from 3 to 7
move 1 from 5 to 1
move 3 from 5 to 6
move 1 from 4 to 3
move 12 from 5 to 6
move 1 from 2 to 8
move 4 from 1 to 7
move 1 from 3 to 2
move 1 from 2 to 6
move 9 from 6 to 4
move 1 from 8 to 7
move 3 from 1 to 2
move 2 from 2 to 5
move 5 from 4 to 6
move 1 from 4 to 6
move 6 from 7 to 3
move 6 from 5 to 7
move 12 from 7 to 4
move 1 from 2 to 8
move 6 from 9 to 5
move 1 from 8 to 9
move 1 from 3 to 6
move 4 from 4 to 1
move 1 from 7 to 9
move 4 from 4 to 6
move 2 from 9 to 7
move 7 from 5 to 1
move 3 from 1 to 4
move 4 from 3 to 1
move 10 from 6 to 9
move 1 from 3 to 5
move 8 from 4 to 6
move 2 from 5 to 2
move 4 from 7 to 4
move 1 from 5 to 9
move 5 from 4 to 7
move 1 from 4 to 8
move 2 from 2 to 6
move 1 from 5 to 3
move 4 from 9 to 6
move 11 from 6 to 8
move 1 from 1 to 4
move 1 from 4 to 1
move 1 from 3 to 1
move 10 from 1 to 4
move 3 from 9 to 5
move 1 from 9 to 3
move 2 from 7 to 4
move 3 from 9 to 4
move 3 from 5 to 8
move 1 from 3 to 5
move 15 from 8 to 2
move 8 from 1 to 4
move 2 from 1 to 2
move 10 from 2 to 3
move 1 from 5 to 7
move 3 from 7 to 8
move 10 from 3 to 5
move 4 from 4 to 2
move 7 from 4 to 1
move 2 from 7 to 4
move 1 from 8 to 9
move 5 from 1 to 6
move 13 from 6 to 2
move 2 from 1 to 4
move 15 from 4 to 5
move 1 from 9 to 3
move 1 from 3 to 4
move 2 from 8 to 3
move 20 from 2 to 6
move 3 from 2 to 8
move 2 from 3 to 8
move 9 from 5 to 2
move 6 from 5 to 9
move 2 from 4 to 1
move 8 from 5 to 4
move 2 from 8 to 1
move 5 from 9 to 5
move 3 from 5 to 7
move 1 from 8 to 2
move 2 from 4 to 1
move 14 from 6 to 4
move 2 from 1 to 8
move 5 from 6 to 3
move 3 from 1 to 6
move 5 from 3 to 2
move 1 from 9 to 6
move 8 from 6 to 2
move 2 from 7 to 4
move 1 from 1 to 3
move 2 from 5 to 8
move 5 from 4 to 3
move 2 from 5 to 3
move 1 from 7 to 5
move 4 from 4 to 3
move 2 from 4 to 2
move 1 from 3 to 7
move 5 from 3 to 7
move 1 from 7 to 3
move 3 from 3 to 2
move 1 from 5 to 9
move 2 from 7 to 9
move 1 from 9 to 5
move 1 from 5 to 3
move 10 from 4 to 9
move 3 from 3 to 9
move 27 from 2 to 5
move 3 from 8 to 3
move 2 from 2 to 6
move 4 from 9 to 7
move 5 from 3 to 8
move 5 from 7 to 3
move 25 from 5 to 1
move 3 from 9 to 8
move 1 from 3 to 2
move 1 from 5 to 3
move 2 from 7 to 9
move 10 from 8 to 7
move 1 from 2 to 3
move 13 from 1 to 7
move 3 from 9 to 7
move 3 from 3 to 1
move 1 from 5 to 8
move 2 from 8 to 6
move 4 from 6 to 5
move 4 from 5 to 6
move 1 from 4 to 6
move 23 from 7 to 9
move 2 from 6 to 8
move 28 from 9 to 1
move 1 from 8 to 1
move 3 from 7 to 3
move 1 from 9 to 4
move 3 from 3 to 6
move 3 from 3 to 4
move 6 from 6 to 8
move 12 from 1 to 7
move 9 from 1 to 6
move 3 from 6 to 3
move 2 from 4 to 7
move 4 from 8 to 7
move 1 from 8 to 5
move 1 from 8 to 4
move 8 from 1 to 7
move 1 from 3 to 4
move 1 from 8 to 3
move 3 from 7 to 5
move 9 from 1 to 3
move 3 from 6 to 5
move 3 from 1 to 7
move 4 from 4 to 2
move 3 from 1 to 4
move 4 from 2 to 8
move 1 from 6 to 2
move 3 from 5 to 6
move 4 from 8 to 5
move 9 from 7 to 6
move 12 from 7 to 1
move 5 from 7 to 3
move 1 from 9 to 7
move 1 from 2 to 9
move 1 from 9 to 4
move 7 from 6 to 3
move 5 from 6 to 2
move 1 from 7 to 6
move 3 from 6 to 1
move 2 from 4 to 9
move 7 from 5 to 8
move 2 from 9 to 4
move 1 from 5 to 8
move 4 from 4 to 1
move 11 from 1 to 7
move 8 from 3 to 1
move 8 from 8 to 6
move 3 from 3 to 5
move 5 from 6 to 1
move 2 from 1 to 2
move 6 from 2 to 3
move 2 from 6 to 7
move 3 from 5 to 4
move 7 from 3 to 9
move 5 from 9 to 5
move 3 from 4 to 3
move 4 from 5 to 2
move 2 from 9 to 4
move 6 from 1 to 9
move 1 from 6 to 9
move 7 from 7 to 1
move 1 from 7 to 3
move 2 from 4 to 5
move 1 from 9 to 1
move 4 from 2 to 3
move 2 from 5 to 2
move 9 from 3 to 1
move 3 from 2 to 4
move 28 from 1 to 6
move 2 from 1 to 3
move 17 from 6 to 3
move 2 from 9 to 5
move 2 from 6 to 7
move 1 from 5 to 7
move 1 from 9 to 4
move 5 from 6 to 9
move 14 from 3 to 5
move 15 from 5 to 9
move 1 from 4 to 9
move 1 from 5 to 6
move 1 from 4 to 1
move 11 from 3 to 6
move 1 from 1 to 6
move 12 from 6 to 8
move 4 from 9 to 7
move 20 from 9 to 4
move 18 from 4 to 5
move 6 from 5 to 8
move 12 from 8 to 2
move 2 from 2 to 6
move 1 from 5 to 2
move 4 from 4 to 8
move 5 from 5 to 9
move 4 from 3 to 6
move 1 from 3 to 8
move 7 from 7 to 8
move 10 from 2 to 8
move 1 from 6 to 3
move 10 from 6 to 5
move 10 from 5 to 2
move 2 from 7 to 5
move 9 from 2 to 1
move 27 from 8 to 9
move 2 from 2 to 7
move 9 from 1 to 2
move 1 from 5 to 3
move 9 from 2 to 1
move 1 from 8 to 7
move 2 from 1 to 3
move 19 from 9 to 1
move 5 from 5 to 1
move 3 from 9 to 2
move 2 from 3 to 9
move 1 from 3 to 4
move 5 from 7 to 4
move 1 from 7 to 3
move 17 from 1 to 2
move 1 from 5 to 3
move 9 from 9 to 5
move 2 from 1 to 2
move 1 from 4 to 9
move 2 from 4 to 6
move 1 from 4 to 7
move 6 from 1 to 8
""".trimIndent()