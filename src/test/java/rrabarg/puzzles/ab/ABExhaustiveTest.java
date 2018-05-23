package rrabarg.puzzles.ab;

class ABExhaustiveTest extends FindKPairsInNTest {

    @Override
    protected FindKPairsInN createInstance() {
        return new ABExhaustive();
    }
}