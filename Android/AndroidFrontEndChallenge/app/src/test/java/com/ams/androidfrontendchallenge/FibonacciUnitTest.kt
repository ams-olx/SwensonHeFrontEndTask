package com.ams.androidfrontendchallenge

import org.junit.Assert
import org.junit.Test
import java.time.Duration
import java.time.Instant

class FibonacciUnitTest {

    @Test
    fun test_recursiveMethod() {
        assert(Fibonacci.recursive(0) == 0L)
        assert(Fibonacci.recursive(1) == 1L)
        assert(Fibonacci.recursive(9) == 34L)
    }

    @Test
    fun test_recursiveMethodWithNegativeNumber() {
        try {
            Fibonacci.recursive(-1)
            Assert.fail("Should have thrown IllegalArgumentException")
        }
        catch (e: IllegalArgumentException) {
            return
        }
    }

    @Test
    fun test_iterativeMethod() {
        assert(Fibonacci.iterative(0) == 0L)
        assert(Fibonacci.iterative(1) == 1L)
        assert(Fibonacci.iterative(9) == 34L)
    }

    @Test
    fun test_iterativeMethodWithNegativeNumber() {
        try {
            Fibonacci.iterative(-1)
            Assert.fail("Should have thrown IllegalArgumentException")
        }
        catch (e: IllegalArgumentException) {
            return
        }
    }

    // Note: the measure function takes about 67 seconds to evaluate result with 50 as an input
    // And the time increases if th input increased
    @Test
    fun test_measurePerformance() {
        assert(measure(Fibonacci::recursive, 50) > measure(Fibonacci::iterative, 50))
    }

    private fun measure(method: (n: Long) -> Long, n: Long): Long {
        val start = Instant.now()
        val result = method(n)
        val finish = Instant.now()
        val timeElapsed = Duration.between(start, finish).toMillis()
        print("\nFibonacci($n) = $result Time elapsed: $timeElapsed ms")
        return timeElapsed
    }
}