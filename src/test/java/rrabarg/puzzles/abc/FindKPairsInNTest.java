package rrabarg.puzzles.abc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class FindKPairsInNTest {

    private FindKPairsInN generator;

    protected abstract rrabarg.puzzles.abc.FindKPairsInN createInstance();

    @BeforeAll
    public void setUp() {
        generator = createInstance();
    }

    @ParameterizedTest
    @CsvSource({"5, 10"})
    public void noSolution(int n, int k) {
        assertImpossible(n, k);
    }

    @ParameterizedTest
    @CsvSource({"3, 3", "3, 0"})
    public void threeThree(int n, int k) {
        assertPossible(n, k);
    }


    @ParameterizedTest
    @CsvSource({"9,5", "6, 5", "15, 36"})
    public void morePairs(int n, int k) {
        assertPossible(n, k);
    }


    protected void assertPossible(int n, int k) {
        assertPossible(n, k, "");
    }

    void assertImpossible(int n, int k) {
        String string = generator.createString(n, k);
        String desc = String.format("%s : (%s,%s)", string, n, k);
        assertThat(desc, string, is(""));
    }

    protected void assertPossible(int n, int k, String example) {
        String string = generator.createString(n, k);
        String desc = String.format("%s : (%s,%s) - %s", string, n, k, example);
        System.out.println(desc);
        assertThat("Length is wrong : " + desc, string.length(), is(n));
        assertThat("Number of pairs is wrong : " + desc, new CountABCs().count(string), is(k));
    }


}