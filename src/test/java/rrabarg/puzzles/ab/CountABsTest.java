package rrabarg.puzzles.ab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountABsTest {

    private CountABs counter = new CountABs();

    @Test
    public void testCount() {
        assertEquals(0, counter.count(""));
        assertEquals(0, counter.count("B"));
        assertEquals(0, counter.count("BA"));
        assertEquals(0, counter.count("BBBBA"));
        assertEquals(0, counter.count("A"));
        assertEquals(1, counter.count("AB"));
        assertEquals(2, counter.count("AAB"));
        assertEquals(4, counter.count("AABB"));
        assertEquals(4, counter.count("AABBA"));
        assertEquals(7, counter.count("AABBAB"));
    }

}