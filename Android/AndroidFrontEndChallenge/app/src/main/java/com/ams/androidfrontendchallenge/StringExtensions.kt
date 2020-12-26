package com.ams.androidfrontendchallenge

fun String.isAnagramOf(string: String) = this.sorted() == string.sorted()

fun String.sorted() = this.toCharArray().sorted().joinToString("").trim()
