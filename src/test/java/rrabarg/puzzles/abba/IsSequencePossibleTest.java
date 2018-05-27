package rrabarg.puzzles.abba;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class IsSequencePossibleTest {

    private IsSequencePossible generator;

    protected abstract IsSequencePossible createInstance();

    @BeforeAll
    public void setUp() {
        generator = createInstance();
    }

    @ParameterizedTest
    @CsvSource({"B, ABBA, Possible", "AB, ABA, Possible", "AB, BAB, Possible"})
    public void oneMovePossible(String from, String to, String expected) {
        doTest(from, to, expected);
    }

    @ParameterizedTest
    @CsvSource({"A, BB, Impossible"})
    public void initialStringAbsentImpossible(String from, String to, String expected) {
        doTest(from, to, expected);
    }

    @ParameterizedTest
    @CsvSource({"AB, ABB, Impossible"})
    public void oneMoveImpossible(String from, String to, String expected) {
        doTest(from, to, expected);
    }

    @ParameterizedTest
    @CsvSource({"BBAB, ABABABABB, Impossible", "BBBBABABBBBBBA, BBBBABABBABBBBBBABABBBBBBBBABAABBBAA, Possible"})
    public void impossible(String from, String to, String expected) {
        doTest(from, to, expected);
    }

    private void doTest(String from, String to, String expected) {
        String actual = generator.canObtain(from, to);
        String desc = String.format("(%s,%s) expected %s, actual %s", from, to, expected, actual);
        assertThat(desc, actual, is(expected));
    }

}