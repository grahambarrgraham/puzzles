package rrabarg.puzzles.ab;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ABTest extends FindKPairsInNTest {

    @Override
    protected FindKPairsInN createInstance() {
        return new AB();
    }

    @ParameterizedTest
    @CsvSource({"1002, 2001"})
    public void bigNTest(int n, int k) {
        paramTest(n, k);
    }

}