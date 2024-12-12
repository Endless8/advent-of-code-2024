package main.days

import main.utils.FileReader

fun main() {
    val fileReader = FileReader()
    val input = fileReader.readFile("/day03-input")

    val mulRegex = Regex("""mul\((\d+),(\d+)\)""")
    val instructionRegex = Regex("""(do\(\)|don't\(\)|mul\(\d+,\d+\))""")

    var isEnabled = true
    var sum = 0

    val instructions = instructionRegex.findAll(input).map { it.value }.toList()

    for (instruction in instructions) {
        when {
            instruction == "do()" -> isEnabled = true
            instruction == "don't()" -> isEnabled = false
            instruction.startsWith("mul") && isEnabled -> {
                val (x, y) = mulRegex.find(instruction)!!.destructured
                sum += x.toInt() * y.toInt()
            }
        }
    }

    println("Sum of enabled multiplications: $sum")
}
