package rrabarg.puzzles.autohamil;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class AutohamilTest {

    @Test
    void case0() {
        assertMatches(new int[]{0, 1}, new int[]{0, 1}, false);
    }

    @Test
    void case1() {
        assertMatches(new int[]{1, 1}, new int[]{1, 1}, true);
    }

    @Test
    void case2() {
        assertMatches(new int[]{1, 2, 2}, new int[]{2, 2, 2}, true);
    }

    @Test
    void case3() {
        assertMatches(new int[]{2, 2, 2}, new int[]{2, 2, 2}, false);
    }

    @Test
    void case4() {
        assertMatches(new int[]{1,2,0,3}, new int[]{3,2,0,3}, true);
    }

    @Test
    void case5() {
        assertMatches(new int[]{1,2,0,4,3,5}, new int[]{1,2,3,5,4,5}, true);
    }

    @Test
    void case6() {
        assertMatches(new int[]{1,2,0,4,4,5}, new int[]{1,2,3,5,4,5}, false);
    }



    private void assertMatches(int[] z0, int[] z1, boolean flag) {
        assertThat(new Autohamil().check(z0, z1), is(flag ? "Exists" : "Does not exist"));
    }

}