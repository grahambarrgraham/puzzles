package rrabarg.puzzles.cheapesttabcomplete;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class CheapestTabCompleteTest {

    private CheapestTabComplete system = new CheapestTabComplete();

    @Test
    void empty() {
        assertKeypresses("myname", 7);
    }

    @Test
    void exactMatch() {
        assertKeypresses("myname", 3, "myn", "myname");
    }

    @Test
    void case2() {
        assertKeypresses("frankie", 5, "abc", "ab", "abcd", "frankies", "frank", "a", "a");
    }

    @Test
    void case4() {
        assertKeypresses("frankie", 8, "a", "a", "f", "f", "fr", "fr", "fra", "fra", "fran", "fran", "frank", "frank");
    }

    @Test
    void case5() {
        assertKeypresses("bcdefghijk", 6, "a", "a", "bcde", "bcde", "bcde", "bcdefghij");
    }

    @Test
    void case6() {
        assertKeypresses("aaaaaaaaaaaaaaaaaaaaaaa", 21, "aaaa", "aaaa", "aaaa", "aaaa", "aaaa");
    }

    @Test
    void case7() {
        assertKeypresses("buzzzc", 7, "b", "bus", "buz", "buzz", "buzzz");
    }

    @Test
    void case8() {
        assertKeypresses("aaad", 3, "aaaa", "aaad");
    }

    @Test
    void case9() {
        assertKeypresses("bcdefghijk", 9, "bcd", "bc", "bcdef", "bcdefgh", "a");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/cheapestTabComplete.csv")
    public void systemTests(String nameArray, String term, int expected) {
        String[] names = nameArray.split(", ");
        List<String> collect = Arrays.stream(names).map(a -> a.trim()).filter(a -> a.length() > 0).collect(Collectors.toList());
        assertKeypresses(term, expected, collect.toArray(new String[collect.size()]));
    }


    void assertKeypresses(String searchTerm, int expectedKeypresses, String... names) {
        assertThat(system.getFewest(names, searchTerm), is(expectedKeypresses));
    }
}
