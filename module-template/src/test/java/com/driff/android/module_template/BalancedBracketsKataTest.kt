package com.driff.android.module_template

import com.driff.android.module_template.presentation.utils.isBalanced
import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * TDDBUDDY.COM
    Balanced Brackets
    The Kata
    Take an input string with X opening brackets [ and Y closing brackets ], in a random order.
    Determine if the generated string of brackets is balanced, that is it consists of pairs of
    opening/closing brackets in the correct order with no matched opening and closing pairs.
    The kata has been structured to be simple, yet loosely guided.
    You will need to make decisions just like you were writing code for production.
    The examples are not meant to guide your implementation, they are there merely to give examples.
    Do not worry about input other than brackets and empty string.
    Examples
    (empty) “”
    [] OK
    [][] OK
    [[]] OK
    [[[][]]] OK
    ][ FAIL
    ][][ FAIL
    [][]][ FAIL
    Hint
    Start off returning string.empty as the default condition. This will allow you properly work the red-green-refactor cycle.
 */
class BalancedBracketsKataTest {

    @Test
    fun `GIVEN an empty string WHEN check if balanced THEN it should return false`() {
        assertFalse("".isBalanced())
    }

    @Test
    fun `GIVEN a single open bracket WHEN check if balanced THEN it should return false`() {
        assertFalse("[".isBalanced())
    }

    @Test
    fun `GIVEN a single close bracket WHEN check if balanced THEN it should return false`() {
        assertFalse("]".isBalanced())
    }

    @Test
    fun `GIVEN an open and closed bracket WHEN check if balanced THEN it should return true`() {
        assertTrue("[]".isBalanced())
    }

    @Test
    fun `GIVEN a pair of brackets and an additional open or closed bracket WHEN check if balanced THEN it should return false`() {
        assertFalse("[][".isBalanced())
        assertFalse("[]]".isBalanced())
    }

    @Test
    fun `GIVEN 2 pair of brackets WHEN check if balanced THEN it should return true`() {
        assertTrue("[][]".isBalanced())
    }

    @Test
    fun `GIVEN a pair of open and closed brackets WHEN check if balanced THEN it should return true`() {
        assertTrue("[[]]".isBalanced())
    }

    @Test
    fun `GIVEN double open and closed brackets with 2 pair of brackets between WHEN check if balanced THEN it should return true`() {
        assertTrue("[[[][]]]".isBalanced())
    }

    @Test
    fun `GIVEN a closed and open bracket WHEN check if balanced THEN it should return false`() {
        assertFalse("][".isBalanced())
    }

    @Test
    fun `GIVEN an array that starts with close bracket WHEN check if balanced THEN it should return false`() {
        assertFalse("][][".isBalanced())
    }

@Test
    fun `GIVEN 2 pairs of brackets followed by a close and open bracket WHEN check if balanced THEN it should return false`() {
        assertFalse("[][]][".isBalanced())
    }


}