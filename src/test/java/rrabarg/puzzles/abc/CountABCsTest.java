package rrabarg.puzzles.abc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountABCsTest {

    private CountABCs counter = new CountABCs();

    @Test
    public void testCount() {
        assertEquals(0, counter.count(""));
        assertEquals(0, counter.count("B"));
        assertEquals(0, counter.count("BA"));
        assertEquals(0, counter.count("CBA"));
        assertEquals(0, counter.count("Completion"));
        assertEquals(1, counter.count("AB"));
        assertEquals(1, counter.count("AC"));
        assertEquals(1, counter.count("BC"));
        assertEquals(3, counter.count("ABC"));
        assertEquals(5, counter.count("ABCC"));
        assertEquals(12, counter.count("AABBCC"));
        assertEquals(14, counter.count("AABBCCBA"));
        assertEquals(7, counter.count("ACCCCCAB"));
        assertEquals(3, counter.count("CABC"));
        assertEquals(15, counter.count("AAAABBAC"));
        assertEquals(12, counter.count("BBCCAACC"));
        assertEquals(6, counter.count("CACACABA"));
    }

}