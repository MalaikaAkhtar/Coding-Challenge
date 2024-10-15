package com.example.codingchallenge

import org.junit.Test

import org.junit.Assert.*

/**
 * Create a Kotlin function that determines whether a given word is an isogram
 * (a word without repeated letters). The function should accept a string input and:
 * Return true if the word is an isogram.
 * Return an array of repeated letters if the word is not an isogram.
 * For example, the input "tomorrow" would return ["o", "r"].
 */
class ExampleUnitTest {
    @Test
    fun firstTest(){
        val expectedOutput = "Malaika is not isogram. Repeatedletters: [a]"
        val word = "Malaika"
        val output = isIsogram(word)
        if (output.isNotEmpty()) {
            println("$word is not isogram. Repeated letters: [${output.joinToString()}]")
        } else {
            println("$word is isogram")
        }
    }
    @Test
    fun secondTest(){
        val word = "Race"
        val output = isIsogram(word)
        if (output.isNotEmpty()) {
            println("$word is not isogram. Repeated letters: [${output.joinToString()}]")
        } else {
            println("$word is isogram")
        }
    }
    @Test
    fun thirdTest(){
        val word = "Capcicum"
        val repeated = isIsogram(word)
        if (repeated.isNotEmpty() ){
            println("$word is not isogram. Repeated letters: [${repeated.joinToString()}]")
        } else {
            println("$word is isogram")
        }
    }
    @Test
    fun failTest(){
        val word = "tomorrow"
        val repeated = isIsogram(word)
        // The test will fail because "tomorrow" is not an isogram, but we expect it to be
        assertTrue("Expected 'tomorrow' to be an isogram", repeated.isEmpty())
    }

    @Test
    fun secondFailTest(){
        val word = "Wrong"
        val output = isIsogram(word)
        // The test will fail because "wrong" is an isogram, but we expect it to be
        assertTrue("Expected 'wrong' is not an isogram", output.isNotEmpty())
    }

/*  This function is finding the isogram. it will take a word and return true if the enter word
    is isogram*/
    private fun isIsogram(word: String): List<Char> {
        val lowercaseWord = word.lowercase()
        val letterCount = mutableMapOf<Char, Int>()
        // Count occurrences of each letter
        for (letter in lowercaseWord) {
            letterCount[letter] = letterCount.getOrDefault(letter, 0) + 1
        }
        // Filter the repeated letters and store them in list
        return letterCount.filter { it.value > 1 }.keys.toList()
    }

}