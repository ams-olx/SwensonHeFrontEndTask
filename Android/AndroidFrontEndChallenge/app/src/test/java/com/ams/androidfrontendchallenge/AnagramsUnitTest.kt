package com.ams.androidfrontendchallenge

import org.junit.Test

class AnagramsUnitTest {

    @Test
    fun test_ListOfWordsAreTrue() {
        listOf("bad\n  credit", "bad credit", "bed car it d").forEach {
            assert("debit card".isAnagramOf(it))
        }
    }

    @Test
    fun test_SingleWordIsTrue() {
        assert("nine thumps".isAnagramOf("punishment"))
    }

    @Test
    fun test_SingleWordIsFalse() {
        // punishment has extra (S) char.
        assert(!"nine thumps".isAnagramOf("punishments"))
    }
}