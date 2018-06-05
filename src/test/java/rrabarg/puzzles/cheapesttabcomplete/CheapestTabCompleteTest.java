package rrabarg.puzzles.cheapesttabcomplete;

import org.junit.jupiter.api.Test;

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

    void assertKeypresses(String searchTerm, int expectedKeypresses, String... names) {
        assertThat(system.getFewest(names, searchTerm), is(expectedKeypresses));
    }
}
