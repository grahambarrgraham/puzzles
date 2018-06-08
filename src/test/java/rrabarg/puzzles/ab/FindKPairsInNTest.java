package rrabarg.puzzles.ab;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class FindKPairsInNTest {

    private FindKPairsInN generator;

    protected abstract FindKPairsInN createInstance();

    @BeforeAll
    public void setUp() {
        generator = createInstance();
    }

    @ParameterizedTest
    @CsvSource({"0,0", "0, 5", "1, 1", "1, 5", "2, 3", "3, 5", "4, 5"})
    public void noSolution(int n, int k) {
        String string = generator.createString(n, k);
        String desc = String.format("%s : (%s,%s)", string, n, k);
        assertThat(desc, string, is(""));
    }

    @ParameterizedTest
    @CsvSource({"2, 1", "3, 1", "10, 1"})
    public void onePair(int n, int k) {
        paramTest(n, k);
    }


    @ParameterizedTest
    @CsvSource({"3, 2", "4, 2", "10, 2"})
    public void twoPairs(int n, int k) {
        paramTest(n, k);
    }

    @ParameterizedTest
    @CsvSource({"5, 5", "4, 3", "6, 7", "4, 4", "5, 6", "7, 11", "11, 7", "8,11", "8,13", "20, 50", "20, 51", "20, 53", "20, 100"})
    public void morePairs(int n, int k) {
        paramTest(n, k);
    }

    @ParameterizedTest
    @CsvSource({"11, 7"})
    public void elevenSeven(int n, int k) {
        paramTest(n, k);
    }

    protected void paramTest(int n, int k) {
        String string = generator.createString(n, k);
        String desc = String.format("%s : (%s,%s)", string, n, k);
        System.out.println(desc);
        assertThat("Length is wrong : " + desc, string.length(), is(n));
        assertThat("Number of pairs is wrong : " + desc, new CountABs().count(string), is(k));
    }

}