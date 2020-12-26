package com.ams.androidfrontendchallenge

object Fibonacci {

    fun recursive(n: Long): Long {
        return when {
            n < 0 -> throwNegativeArgumentException()
            else  -> if (n < 2) n else recursive(n - 1) + recursive(n - 2)
        }
    }

    fun iterative(n: Long): Long {
        return when {
            n < 0    -> throwNegativeArgumentException()
            n <= 2 -> n
            else     -> {
                var minusOne = 1L
                var minusTwo = 0L
                var result: Long = minusOne
                for (i in 2..n) {
                    result = minusOne + minusTwo
                    minusTwo = minusOne
                    minusOne = result
                }
                return result
            }
        }
    }

    private fun throwNegativeArgumentException(): Nothing {
        throw IllegalArgumentException("n value cannot be negative number")
    }
}