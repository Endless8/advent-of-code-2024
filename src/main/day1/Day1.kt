package main.day1

import main.utils.FileReader
import kotlin.math.absoluteValue

fun main()
{
    val fileReader = FileReader()
    val input = fileReader.readFile("/day1-input")

    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()

    input.lines().forEach {
        val numbers = "\\d+".toRegex()
            .findAll(it)
            .map { it.value.toInt() }
            .toList()
        leftList.add(numbers[0])
        rightList.add(numbers[1])
    }

    leftList.sort()
    rightList.sort()

    var distance = getDistance(leftList, rightList)
    println("Distance: $distance")
    var totalSimilarityScore = getSimilarityScore(leftList, rightList)
    println("Similarity score: $totalSimilarityScore")
}

private fun getSimilarityScore(
    leftList: MutableList<Int>,
    rightList: MutableList<Int>
): Int
{
    var totalSimilarityScore = 0

    leftList.forEach { leftNumber ->
        var similarityScore = 0

        rightList.forEach { rightNumber ->
            if (rightNumber == leftNumber)
            {
                similarityScore++
            }
        }

        totalSimilarityScore += leftNumber * similarityScore
    }

    return totalSimilarityScore
}

private fun getDistance(
    leftList: MutableList<Int>,
    rightList: MutableList<Int>
): Int
{
    var distance = 0

    for (index in leftList.indices)
    {
        val leftNumber = leftList[index]
        val rightNumber = rightList[index]

        distance += (leftNumber - rightNumber).absoluteValue
    }

    return distance
}