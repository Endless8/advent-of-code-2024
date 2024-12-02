package main.days

import main.utils.FileReader

fun main() {
    val input = FileReader().readFile("/day02-input")

    val inputLines = input.split("\r\n")
    println("Part One Safe Reports: ${countSafeReports(inputLines)}")
    println("Part Two Safe Reports: ${countSafeReportsWithProblemDampener(inputLines)}")
}

fun countSafeReports(reports: List<String>): Int {
    return reports.count { report ->
        val levels = report.split(" ").map { it.toInt() }
        isReportSafe(levels)
    }
}

fun countSafeReportsWithProblemDampener(reports: List<String>): Int {
    return reports.count { report ->
        val levels = report.split(" ").map { it.toInt() }
        isReportSafeWithDampener(levels)
    }
}

fun isReportSafe(levels: List<Int>): Boolean {
    val isIncreasing = levels.zipWithNext().all { (a, b) -> b - a in 1..3 }
    val isDecreasing = levels.zipWithNext().all { (a, b) -> a - b in 1..3 }
    return isIncreasing || isDecreasing
}

fun isReportSafeWithDampener(levels: List<Int>): Boolean {
    if (isReportSafe(levels)) return true

    return levels.indices.any { indexToRemove ->
        val modifiedLevels = levels.filterIndexed { index, _ -> index != indexToRemove }
        isReportSafe(modifiedLevels)
    }
}
