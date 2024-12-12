#!/bin/bash
kotlinc $(find src -name "*.kt") -d bin
java -cp "bin:/home/gitpod/.sdkman/candidates/kotlin/current/lib/kotlin-stdlib.jar" main.days.Day03Kt