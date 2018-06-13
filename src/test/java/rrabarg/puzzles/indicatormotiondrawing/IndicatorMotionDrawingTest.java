package rrabarg.puzzles.indicatormotiondrawing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class IndicatorMotionDrawingTest {

    private IndicatorMotionDrawing system = new IndicatorMotionDrawing();

    @Test
    void x1Cases() {
        assertMoves(new String[]{"/", "|"}, '-', 3);
        assertMoves(new String[]{"/", " "}, '-', 1);
        assertMoves(new String[]{"/"}, '-', 1);
        assertMoves(new String[]{"/-"}, '-', 3);
    }

    @Test
    void x2Cases() {
        assertMoves(new String[]{"/-", "|\\"}, '-', 7);
        assertMoves(new String[]{"/-", "-\\"}, '-', 7);
        assertMoves(new String[]{"/-", "- "}, '-', 5);
    }

    @Test
    void x3Case1() {
        assertMoves(new String[]{" //", "///", "---"}, '-', -1);
    }

    @Test
    void x3Case2() {
        assertMoves(new String[]{"///", "///", "---"}, '-', 10);
    }

    @Test
    void x3Case3() {
        assertMoves(new String[]{"/- ", "/  ", "/--"}, '/', 9);
    }

    @Test
    void x3Case4() {
        assertMoves(new String[]{"|/", "|\\"}, '|', 5);
    }

    @Test
    void x4Case5() {
        assertMoves(new String[]{"--//", "|   ", "||||"}, '/', 13);
    }

    @Test
    void x3Case6() {
        assertMoves(new String[]{"/-\\", "|\\-", "-/|"}, '\\', 17);
    }

    @Test
    void x4Case1() {
        assertMoves(new String[]{"/-|/", "/ |/", "-/\\/"}, '\\', 18);
    }

    @Test
    void x4Case2() {
        assertMoves(new String[]{"\\-\\-", "-  \\", "\\-\\-"}, '-', 19);
    }

    @Test
    void x4Case3() {
        assertMoves(new String[]{"/ \\|", "|\\- ", "- |\\"}, '\\', 19);
    }

    @Test
    void x4Case4() {
        assertMoves(new String[]{"/| -", " - \\", "\\-|/"}, '|', 18);
    }

    @Test
    void tcCase86() {
        assertMoves(new String[]{"\\ \\-", "-- \\", "\\|| "}, '-', -1);
    }

    @Test
    void tcCase21() {
        assertMoves(new String[]{"/-\\|", "|\\-/", "-/|\\"}, '\\', 23);
    }

    @Test
    void x4Case6() {
        assertMoves(new String[]{"||||", "||||", "||||", "||||"}, '|', 15);
    }

    @Test
    void x5Case1() {
        assertMoves(new String[]{"|||||", "|||||", "|||||", "|||||", "|||||"}, '|', 24);
    }

    void assertMoves(String[] initialState, char startState, int expectedMoves) {
        assertThat(system.getMinSteps(initialState, startState), is(expectedMoves));
    }

}