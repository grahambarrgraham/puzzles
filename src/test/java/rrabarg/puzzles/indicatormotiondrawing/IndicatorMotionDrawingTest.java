package rrabarg.puzzles.indicatormotiondrawing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class IndicatorMotionDrawingTest {

    private IndicatorMotionDrawing system = new IndicatorMotionDrawing();

    @Test
    void empty() {
        assertMoves(new String[]{}, '/', 0);
    }

    void assertMoves(String[] initialState, char startState, int expectedMoves) {
        assertThat(system.getMinSteps(initialState, startState), is(expectedMoves));
    }

    @Test
    public void moves3x3() {
        assertThat(IndicatorMotionDrawing.moves(0, 0, new String[] {"///","///","///"}), is(new char[]{'D', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(0, 1, new String[] {"///","///","///"}), is(new char[]{'U', 'D', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(0, 2, new String[] {"///","///","///"}), is(new char[]{'U', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(1, 0, new String[] {"///","///","///"}), is(new char[]{'D', 'L', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(1, 1, new String[] {"///","///","///"}), is(new char[]{'U', 'D', 'L', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(1, 2, new String[] {"///","///","///"}), is(new char[]{'U', 'L', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(2, 0, new String[] {"///","///","///"}), is(new char[]{'D', 'L'}));
        assertThat(IndicatorMotionDrawing.moves(2, 1, new String[] {"///","///","///"}), is(new char[]{'U', 'D', 'L'}));
        assertThat(IndicatorMotionDrawing.moves(2, 2, new String[] {"///","///","///"}), is(new char[]{'U', 'L'}));
    }

    @Test
    public void moves4x4() {
        assertThat(IndicatorMotionDrawing.moves(0, 0, new String[] {"////","////","////","////"}), is(new char[]{'D', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(0, 1, new String[] {"////","////","////","////"}), is(new char[]{'U', 'D', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(0, 2, new String[] {"////","////","////","////"}), is(new char[]{'U', 'D', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(0, 3, new String[] {"////","////","////","////"}), is(new char[]{'U', 'R'}));

        assertThat(IndicatorMotionDrawing.moves(1, 0, new String[] {"////","////","////","////"}), is(new char[]{'D', 'L', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(1, 1, new String[] {"////","////","////","////"}), is(new char[]{'U', 'D', 'L', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(1, 2, new String[] {"////","////","////","////"}), is(new char[]{'U', 'D', 'L', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(1, 3, new String[] {"////","////","////","////"}), is(new char[]{'U', 'L', 'R'}));

        assertThat(IndicatorMotionDrawing.moves(2, 0, new String[] {"////","////","////","////"}), is(new char[]{'D', 'L', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(2, 1, new String[] {"////","////","////","////"}), is(new char[]{'U', 'D', 'L', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(2, 2, new String[] {"////","////","////","////"}), is(new char[]{'U', 'D', 'L', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(2, 3, new String[] {"////","////","////","////"}), is(new char[]{'U', 'L', 'R'}));

        assertThat(IndicatorMotionDrawing.moves(3, 0, new String[] {"////","////","////","////"}), is(new char[]{'D', 'L'}));
        assertThat(IndicatorMotionDrawing.moves(3, 1, new String[] {"////","////","////","////"}), is(new char[]{'U', 'D', 'L'}));
        assertThat(IndicatorMotionDrawing.moves(3, 2, new String[] {"////","////","////","////"}), is(new char[]{'U', 'D', 'L'}));
        assertThat(IndicatorMotionDrawing.moves(3, 3, new String[] {"////","////","////","////"}), is(new char[]{'U', 'L'}));
    }

    @Test
    public void movesWithBlanks() {
        assertThat(IndicatorMotionDrawing.moves(1, 0, new String[] {"///","/ /","///"}), is(new char[]{'L', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(0, 1, new String[] {"///","/ /","///"}), is(new char[]{'U', 'D'}));
        assertThat(IndicatorMotionDrawing.moves(2, 1, new String[] {"///","/ /","///"}), is(new char[]{'U', 'D'}));
        assertThat(IndicatorMotionDrawing.moves(1, 2, new String[] {"///","/ /","///"}), is(new char[]{'L', 'R'}));
        assertThat(IndicatorMotionDrawing.moves(0, 0, new String[] {"/ /"," //","///"}), is(new char[]{}));
    }

}