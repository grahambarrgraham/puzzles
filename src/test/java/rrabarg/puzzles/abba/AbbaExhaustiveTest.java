package rrabarg.puzzles.abba;

public class AbbaExhaustiveTest extends IsSequencePossibleTest {

    @Override
    protected IsSequencePossible createInstance() {
        return new AbbaExhaustive();
    }
}