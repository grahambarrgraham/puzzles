import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class AB {

    public String createString(int n, int k) {
        return generateCombinations(new char[]{'A', 'B'}, n)
                .stream()
                .sorted()
                .parallel()
                .filter(s -> count(s) == k)
                .findFirst()
                .orElse("");
    }

    private List<String> generateCombinations(char[] set, int k) {
        List<String> result = new ArrayList<>();
        int n = set.length;
        generateCombinations(set, "", n, k, result);
        return result;
    }

    private void generateCombinations(char[] set, String prefix, int n, int k, List<String> result) {

        if (k == 0) {
            result.add(prefix);
            return;
        }

        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i];
            generateCombinations(set, newPrefix, n, k - 1, result);
        }
    }

    private int count(String s) {

        int count = 0;
        int aCount = 0;
        int bCount = 0;
        char lastChar = '0';

        for (char c : s.toCharArray()) {
            if ('A' == c) {

                if (lastChar == 'B') {
                    count += aCount * bCount;
                    aCount = 0;
                    bCount = 0;
                }
                aCount++;

            } else {
                bCount++;
            }

            lastChar = c;
        }

        count += aCount * bCount;

        return count;
    }


    @Test
    public void testCount() {
        assertEquals(0, count(""));
        assertEquals(0, count("B"));
        assertEquals(0, count("BA"));
        assertEquals(0, count("BBBBA"));
        assertEquals(0, count("A"));
        assertEquals(1, count("AB"));
        assertEquals(2, count("AAB"));
        assertEquals(4, count("AABB"));
        assertEquals(4, count("AABBA"));
        assertEquals(5, count("AABBAB"));
    }


    @Test
    public void lengthZero() {
        assertEquals("", createString(0, 0));
        assertEquals("", createString(0, 5));
        assertEquals("", createString(0, 1000));
    }

    @Test
    public void noPairs() {
        assertEquals("A", createString(1, 0));
        assertEquals("AA", createString(2, 0));
        assertEquals("AAA", createString(3, 0));
        assertEquals("AAAA", createString(4, 0));
        assertEquals("AAAAA", createString(5, 0));
        assertEquals("AAAAAA", createString(6, 0));
        assertEquals("AAAAAAA", createString(7, 0));
        assertEquals("AAAAAAAA", createString(8, 0));
        assertEquals("AAAAAAAAA", createString(9, 0));
    }

    @Test
    public void onePair() {
        assertEquals("", createString(1, 1));
        assertEquals("AB", createString(2, 1));
        assertEquals("ABA", createString(3, 1));
        assertEquals("ABAA", createString(4, 1));
        assertEquals("ABAAAAAAAA", createString(10, 1));
    }

    @Test
    public void twoPairs() {
        assertEquals("", createString(1, 2));
        assertEquals("", createString(2, 2));
        assertEquals("AAB", createString(3, 2));
        assertEquals("AABA", createString(4, 2));
        assertEquals("AABAAAAAAA", createString(10, 2));
    }

    @Test
    public void fivePairs() {
        assertEquals("", createString(1, 5));
        assertEquals("", createString(2, 5));
        assertEquals("", createString(3, 5));
        assertEquals("AAAAAB", createString(6, 5));
        assertEquals("AAAAABAAAA", createString(10, 5));
    }

    @Test
    public void multiplier2() {
        assertEquals("AABB", createString(4, 4));
        assertEquals("AAAAAABBAA", createString(10, 12));
    }

    @Test
    public void multiplier3() {
        assertEquals("AAABB", createString(5, 6));
        assertEquals("AAAAAAAABB", createString(10, 16));
    }

}
