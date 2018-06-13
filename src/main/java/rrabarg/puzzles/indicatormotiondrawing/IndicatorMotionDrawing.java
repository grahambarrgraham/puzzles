package rrabarg.puzzles.indicatormotiondrawing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;

public class IndicatorMotionDrawing {

    public int getMinSteps(String[] desiredState, char startState) {

        TreeSet<State> open = new TreeSet<>(comparingInt((State o) -> o.score(desiredState))
                        .thenComparingInt(o -> o.moves.length())
                        .thenComparingInt(State::hashCode));

        open.add(State.startState(desiredState, startState));
        Set<State> closed = new HashSet<>();

        while (!open.isEmpty()) {
            State currentState = open.pollFirst();
            closed.add(currentState);

            if (Arrays.equals(desiredState, currentState.screen)) {
                System.out.println("Finished " + currentState + " open " + open.size() + " closed " + closed.size());
                return currentState.moves.length();
            }

            currentState.generateMoves(desiredState)
                    .filter(state -> state.score(desiredState) < 10000)
                    .filter(state -> !closed.contains(state))
                    .forEach(open::add);
        }

        System.out.println("closed " + closed.size());

        return -1;
    }

    static class State {
        String moves;
        String[] screen;
        int x;
        int y;

        State(int x, int y, String moves, String... screen) {
            this.screen = screen;
            this.x = x;
            this.y = y;
            this.moves = moves;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return x == state.x && y == state.y && Arrays.equals(screen, state.screen);
        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(screen);
            result = 31 * result + x;
            result = 31 * result + y;
            return result;
        }

        Stream<State> generateMoves(String[] desiredState) {
            return generate(desiredState).chars().mapToObj(i -> move((char) i));
        }

        State move(char move) {

            String nextMoves = this.moves + move;

            switch (move) {
                case 'L':
                    return new State(x - 1, y, nextMoves, move(x - 1, y, screen[y].charAt(x), screen));
                case 'R':
                    return new State(x + 1, y, nextMoves, move(x + 1, y, screen[y].charAt(x), screen));
                case 'U':
                    return new State(x, y - 1, nextMoves, move(x, y - 1, screen[y].charAt(x), screen));
                case 'D':
                    return new State(x, y + 1, nextMoves, move(x, y + 1, screen[y].charAt(x), screen));
                case 'F':
                    return new State(x, y, nextMoves, move(x, y, flip(screen[y].charAt(x)), screen));
                case '<':
                    return new State(x, y, nextMoves, move(x, y, rotateAnti(screen[y].charAt(x)), screen));
                case '>':
                    return new State(x, y, nextMoves, move(x, y, rotateCw(screen[y].charAt(x)), screen));
            }

            return null;
        }

        String generate(String... desiredState) {
            int width = desiredState[0].length();
            int height = desiredState.length;

            StringBuilder builder = new StringBuilder("<>F");

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

            return builder.toString();
        }

        boolean isNotBlank(String[] s, int x, int y) {
            return s[y].charAt(x) != ' ';
        }

        int score(String[] desiredState) {

            int minMovesRemaining = 0;
            for (int x = 0; x < desiredState[0].length(); x++) {
                for (int y = 0; y < desiredState.length; y++) {
                    if (screen[y].charAt(x) != desiredState[y].charAt(x)) {
                        minMovesRemaining++;
                        if (incorrectNeighbours(x,y, desiredState, screen).indexOf(desiredState[y].charAt(x)) == -1) {
                            minMovesRemaining++;
                        }
                    }
                    if (desiredState[y].charAt(x) == ' ' && screen[y].charAt(x) != ' ') {
                        return 10000;
                    }
                }
            }


            return moves.length() + minMovesRemaining;
        }

        String incorrectNeighbours(int x, int y, String[] desiredState, String[] screen) {
            int width = desiredState[0].length();
            int height = desiredState.length;

            StringBuilder builder = new StringBuilder();

            if (y > 0 && notMatches(screen, desiredState, x, y - 1)) {
                builder.append(desiredState[y-1].charAt(x));
            }

            if (y < height - 1 && notMatches(screen, desiredState, x, y + 1)) {
                builder.append(desiredState[y+1].charAt(x));
            }

            if (x > 0 && notMatches(screen, desiredState, x - 1, y)) {
                builder.append(desiredState[y].charAt(x-1));
            }


            if (x < width - 1 && notMatches(screen, desiredState, x + 1, y)) {
                builder.append(desiredState[y].charAt(x+1));
            }

            return builder.toString();
        }

        private boolean notMatches(String[] screen, String[] desiredState, int x, int y) {
            return screen[y].charAt(x) != desiredState[y].charAt(x);
        }

        char rotateCw(char c) {
            switch (c) {
                case '/':
                    return '-';
                case '-':
                    return '\\';
                case '\\':
                    return '|';
                case '|':
                    return '/';
            }

            throw new RuntimeException("Invalid cw " + c);
        }

        char rotateAnti(char c) {
            switch (c) {
                case '/':
                    return '|';
                case '|':
                    return '\\';
                case '\\':
                    return '-';
                case '-':
                    return '/';
            }

            throw new RuntimeException("Invalid anti cw " + c);
        }

        char flip(char c) {
            switch (c) {
                case '/':
                    return '\\';
                case '|':
                    return '-';
                case '-':
                    return '|';
                case '\\':
                    return '/';
            }

            throw new RuntimeException("Invalid flip " + c);
        }

        String[] move(int x, int y, char c, String[] currentState) {
            char[] chars = currentState[y].toCharArray();
            chars[x] = c;
            String[] result = new String[currentState.length];
            for (int i = 0; i < currentState.length; i++) {
                result[i] = y == i ? new String(chars) : currentState[i];
            }
            return result;
        }

        @Override
        public String toString() {
            return String.format("{%s,%s} %s %s", x, y, Arrays.toString(screen), moves);
        }

        public static State startState(String[] desiredState, char startChar) {
            String[] startState = new String[desiredState.length];

            for (int y = 0; y < desiredState.length; y++) {
                StringBuffer buffer = new StringBuffer();
                for (int x = 0; x < desiredState[y].length(); x++) {
                    buffer.append((x == 0 && y == 0) ? startChar : ' ');
                }
                startState[y] = buffer.toString();
            }
            return new State(0, 0, "", startState);
        }
    }

}

