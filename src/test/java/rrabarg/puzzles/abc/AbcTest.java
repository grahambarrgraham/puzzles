package rrabarg.puzzles.abc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class AbcTest extends FindKPairsInNTest {

    @Override
    protected FindKPairsInN createInstance() {
        return new Abc();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/abcTest.csv")
    public void systemTests(int from, int to, String example) {
        if (example == null || example.trim() == "") {
            assertImpossible(from, to);
        } else {
            assertPossible(from, to, example);
        }
    }

}