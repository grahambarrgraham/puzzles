package rrabarg.puzzles.ab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HeadToHeadTest {

    private FindKPairsInN ab =new AB();
    private FindKPairsInN abI =new ABIterative();
    private FindKPairsInN abE =new ABExhaustive();

    @Test
    public void testAlgorithmsAreEquivalent() {
        for (int n = 0; n < 20; n++) {
            for (int k = 0; k < 100; k++) {
                paramTest(n, k);
            }
        }
    }

    private void paramTest(int n, int k) {
        String s = ab.createString(n, k);
        String sI = abI.createString(n, k);
        String sE = abE.createString(n, k);
        String desc = String.format("%s, %s, %s : (%s,%s)", s, sI, sE, n, k);
        System.out.println(desc);
        assertThat("AB : Length is wrong : " + desc, s.length(), is(sE.length()));
        assertThat("AB : Number of pairs is wrong : " + desc, new CountABs().count(s), is(new CountABs().count(sE)));
        assertThat("ABI : Length is wrong : " + desc, sI.length(), is(sE.length()));
        assertThat("ABI : Number of pairs is wrong : " + desc, new CountABs().count(sI), is(new CountABs().count(sE)));
    }

}