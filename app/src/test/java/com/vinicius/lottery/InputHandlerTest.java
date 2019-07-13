package com.vinicius.lottery;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class InputHandlerTest {

    final InputParser inputParser = new InputParser();

    @Test(expected = Exception.class)
    public void shouldThrowException_nonDigitsInput() throws Exception {
        String testInput = "a";
        inputParser.parse(testInput);
    }

    @Test(expected = Exception.class)
    public void shouldThrowException_lessNumbersInput() throws Exception {
        String testInput = "1,2,3";
        inputParser.parse(testInput);
    }

    @Test(expected = Exception.class)
    public void shouldThrowException_notCommaSeparatedInput() throws Exception {
        String testInput = "1;2,3,3,3,3,3,3,3,3,3,3,3,3,3";
        inputParser.parse(testInput);
    }

    @Test
    public void shouldParseCorrectly() {
        String testInput = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
        LinkedList<Integer> parsedInput = null;
        try {
            parsedInput = (LinkedList<Integer>) inputParser.parse(testInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LinkedList<Integer> expectedOutput = new LinkedList<>();

        for(int i = 1; i <= 15; i++) {
            expectedOutput.add(i);
        }

        assertEquals(parsedInput, expectedOutput);
    }
}