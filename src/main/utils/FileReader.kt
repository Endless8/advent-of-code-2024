/*
 * MiMIT UIBM - Digital Identity API
 *
 * Copyright (C) 2024 IBM Consulting Italy - All Rights Reserved
 * This is copyrighted software
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential by IBM Consulting
 *
 */

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