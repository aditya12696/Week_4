package queuequestiontest.binarynumbersgeneratortest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import queuequestion.binarynumbersgenerator.BinaryNumbersGenerator;

import java.util.*;

public class BinaryNumbersGeneratorTest {

    @Test
    void testGenerateBinaryNumbers() {
        // Test with N = 5
        List<String> expected = Arrays.asList("1", "10", "11", "100", "101");
        assertEquals(expected, BinaryNumbersGenerator.generateBinaryNumbers(5));
    }

    @Test
    void testGenerateBinaryNumbersN1() {
        // Test with N = 1
        List<String> expected = Arrays.asList("1");
        assertEquals(expected, BinaryNumbersGenerator.generateBinaryNumbers(1));
    }

    @Test
    void testGenerateBinaryNumbersN10() {
        // Test with N = 10
        List<String> expected = Arrays.asList("1", "10", "11", "100", "101", "110", "111", "1000", "1001", "1010");
        assertEquals(expected, BinaryNumbersGenerator.generateBinaryNumbers(10));
    }

    @Test
    void testGenerateBinaryNumbersN0() {
        // Test with N = 0 (edge case)
        List<String> expected = new ArrayList<>();
        assertEquals(expected, BinaryNumbersGenerator.generateBinaryNumbers(0));
    }
}

