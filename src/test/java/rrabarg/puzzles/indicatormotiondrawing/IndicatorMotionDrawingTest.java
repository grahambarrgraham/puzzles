package rrabarg.puzzles.indicatormotiondrawing;

import org.junit.jupiter.api.Test;
import rrabarg.puzzles.indicatormotiondrawing.IndicatorMotionDrawing.State;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class IndicatorMotionDrawingTest {

    private IndicatorMotionDrawing system = new IndicatorMotionDrawing();

    @Test
    void empty() {
        assertMoves(new String[]{" //", "///", "---"}, '-', -1);
    }

    @Test
    void simple() {
        assertMoves(new String[]{"///", "///", "---"}, '-', 10);
    }

    @Test
    void blanks() {
        assertMoves(new String[]{"/- ", "/  ", "/--"}, '/', 9);
    }

    @Test
    void x4() {
        assertMoves(new String[]{"/-|/", "/ |/", "-/\\/"}, '\\', 18);
    }

    void assertMoves(String[] initialState, char startState, int expectedMoves) {
        assertThat(system.getMinSteps(initialState, startState), is(expectedMoves));
    }

    @Test
    void moves3x3() {
        assertThat(new State(0, 0, "").generate("///", "///", "///").toCharArray(), is(new char[]{'<', '>', 'F', 'D', 'R'}));
        assertThat(new State(0, 1, "").generate("///", "///", "///").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'D', 'R'}));
        assertThat(new State(0, 2, "").generate("///", "///", "///").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'R'}));
        assertThat(new State(1, 0, "").generate("///", "///", "///").toCharArray(), is(new char[]{'<', '>', 'F', 'D', 'L', 'R'}));
        assertThat(new State(1, 1, "").generate("///", "///", "///").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'D', 'L', 'R'}));
        assertThat(new State(1, 2, "").generate("///", "///", "///").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'L', 'R'}));
        assertThat(new State(2, 0, "").generate("///", "///", "///").toCharArray(), is(new char[]{'<', '>', 'F', 'D', 'L'}));
        assertThat(new State(2, 1, "").generate("///", "///", "///").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'D', 'L'}));
        assertThat(new State(2, 2, "").generate("///", "///", "///").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'L'}));
    }

    @Test
    void moves4x4() {
        assertThat(new State(0, 0, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'D', 'R'}));
        assertThat(new State(0, 1, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'D', 'R'}));
        assertThat(new State(0, 2, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'D', 'R'}));
        assertThat(new State(0, 3, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'R'}));

        assertThat(new State(1, 0, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'D', 'L', 'R'}));
        assertThat(new State(1, 1, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'D', 'L', 'R'}));
        assertThat(new State(1, 2, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'D', 'L', 'R'}));
        assertThat(new State(1, 3, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'L', 'R'}));

        assertThat(new State(2, 0, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'D', 'L', 'R'}));
        assertThat(new State(2, 1, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'D', 'L', 'R'}));
        assertThat(new State(2, 2, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'D', 'L', 'R'}));
        assertThat(new State(2, 3, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'L', 'R'}));

        assertThat(new State(3, 0, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'D', 'L'}));
        assertThat(new State(3, 1, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'D', 'L'}));
        assertThat(new State(3, 2, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'D', 'L'}));
        assertThat(new State(3, 3, "").generate("////", "////", "////", "////").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'L'}));
    }

    @Test
    void movesWithBlanks() {
        assertThat(new State(1, 0, "").generate("///", "/ /", "///").toCharArray(), is(new char[]{'<', '>', 'F', 'L', 'R'}));
        assertThat(new State(0, 1, "").generate("///", "/ /", "///").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'D'}));
        assertThat(new State(2, 1, "").generate("///", "/ /", "///").toCharArray(), is(new char[]{'<', '>', 'F', 'U', 'D'}));
        assertThat(new State(1, 2, "").generate("///", "/ /", "///").toCharArray(), is(new char[]{'<', '>', 'F', 'L', 'R'}));
        assertThat(new State(0, 0, "").generate("/ /", " //", "///").toCharArray(), is(new char[]{'<', '>', 'F'}));
    }

    @Test
    void applyMove() {
        assertThat(new State(0, 0, "", "-//", "/ /", "///").move('R'), is(new State(1, 0, "", "--/", "/ /", "///")));
        assertThat(new State(1, 1, "", "///", "/\\/", "///").move('L'), is(new State(0, 1, "", "///", "\\\\/", "///")));
        assertThat(new State(1, 1, "", "///", "///", "/ /").move('D'), is(new State(1, 2, "", "///", "///", "///")));
        assertThat(new State(1, 1, "", "/-/", "/|/", "///").move('U'), is(new State(1, 0, "", "/|/", "/|/", "///")));
    }

    @Test
    void applyRotate() {
        assertThat(new State(1, 0, "", "///", "/ /", "///").move('F'), is(new State(1, 0, "", "/\\/", "/ /", "///")));
        assertThat(new State(1, 0, "", "/|/", "/ /", "///").move('F'), is(new State(1, 0, "", "/-/", "/ /", "///")));
        assertThat(new State(1, 0, "", "/-/", "/ /", "///").move('F'), is(new State(1, 0, "", "/|/", "/ /", "///")));
        assertThat(new State(1, 0, "", "/\\/", "/ /", "///").move('F'), is(new State(1, 0, "", "///", "/ /", "///")));

        assertThat(new State(1, 1, "", "///", "/\\/", "///").move('>'), is(new State(1, 1, "", "///", "/|/", "///")));
        assertThat(new State(1, 1, "", "///", "/|/", "///").move('>'), is(new State(1, 1, "", "///", "///", "///")));
        assertThat(new State(1, 1, "", "///", "///", "///").move('>'), is(new State(1, 1, "", "///", "/-/", "///")));
        assertThat(new State(1, 1, "", "///", "/-/", "///").move('>'), is(new State(1, 1, "", "///", "/\\/", "///")));

        assertThat(new State(1, 1, "", "///", "/\\/", "///").move('<'), is(new State(1, 1, "", "///", "/-/", "///")));
        assertThat(new State(1, 1, "", "///", "/-/", "///").move('<'), is(new State(1, 1, "", "///", "///", "///")));
        assertThat(new State(1, 1, "", "///", "///", "///").move('<'), is(new State(1, 1, "", "///", "/|/", "///")));
        assertThat(new State(1, 1, "", "///", "/|/", "///").move('<'), is(new State(1, 1, "", "///", "/\\/", "///")));
    }

    @Test
    void score() {
        assertThat(new State(0, 0, "", "/  ", "   ", "   ").score(new String[]{"///", "///", "///"}), is(8));
        assertThat(new State(0, 0, ">", "/  ", "   ", "   ").score(new String[]{"///", "///", "///"}), is(9));
        assertThat(new State(0, 0, ">DU", "/  ", "   ", "   ").score(new String[]{"///", "///", "///"}), is(11));

        assertThat(new State(0, 0, "", "/  ", "   ", "   ").score(new String[]{"///", "/ /", "///"}), is(7));
        assertThat(new State(0, 0, "", "/  ", "   ", "   ").score(new String[]{"///", "/ /", "   "}), is(4));
        assertThat(new State(0, 0, "", "-/\\", "/\\/", "-||").score(new String[]{"-/\\", "/\\/", "-||"}), is(0));
        assertThat(new State(0, 0, "", "-/\\", "/\\/", "-||").score(new String[]{"-/\\", "/\\/", "-| "}), is(10000));
    }

}