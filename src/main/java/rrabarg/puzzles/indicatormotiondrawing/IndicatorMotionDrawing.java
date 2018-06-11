package rrabarg.puzzles.indicatormotiondrawing;

public class IndicatorMotionDrawing {

    public int getMinSteps(String[] desiredState, char startState) {
        return 0;
    }

    static String[] move(int x, int y, char move, String[] currentState) {
        
    }

    static char[] moves(int x, int y, String[] desiredState) {
        int width = desiredState[0].length();
        int height = desiredState.length;

        StringBuilder builder = new StringBuilder();

        if (y > 0 && isNotBlank(desiredState, x, y - 1)) {
            builder.append('U');
        }

        if (y < height - 1 && isNotBlank(desiredState, x, y + 1)) {
            builder.append('D');
        }

        if (x > 0 && isNotBlank(desiredState, x - 1, y)) {
            builder.append('L');
        }

        if (x < width - 1 && isNotBlank(desiredState, x + 1, y)) {
            builder.append('R');
        }

        return builder.toString().toCharArray();

    }

    private static boolean isNotBlank(String[] s, int x, int y) {
        return s[y].charAt(x) != ' ';
    }

}
