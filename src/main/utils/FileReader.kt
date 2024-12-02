package main.utils

import java.io.File

const val basePath = "src/main/resources"

class FileReader
{
    fun readFile(filePath: String): String {
        val content = File(basePath.plus(filePath)).readText()
        return content
    }
}
