package rrabarg.puzzles.abc;

class AbcExhaustiveTest extends FindKPairsInNTest {

    @Override
    protected rrabarg.puzzles.abc.FindKPairsInN createInstance() {
        return new AbcExhaustive();
    }
}