package rrabarg.puzzles.abc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HeadToHeadTest {

    private FindKPairsInN ab =new Abc();
    private FindKPairsInN abE =new AbcExhaustive();

    @Test
    void testAlgorithmsAreEquivalent() {
        for (int n = 0; n < 12; n++) {
            for (int k = 0; k < 100; k++) {
                paramTest(n, k);
            }
        }
    }

    private void paramTest(int n, int k) {
        String s = ab.createString(n, k);
        String sE = abE.createString(n, k);
        String desc = String.format("%s, %s : (%s,%s)", s, sE, n, k);
        System.out.println(desc);
        assertThat("AB : Length is wrong : " + desc, s.length(), is(sE.length()));
        assertThat("AB : Number of pairs is wrong : " + desc, new CountABCs().count(s), is(new CountABCs().count(sE)));
    }

}