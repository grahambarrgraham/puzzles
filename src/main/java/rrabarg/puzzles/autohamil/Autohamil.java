package rrabarg.puzzles.autohamil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;

public class Autohamil {

    public String check(int[] z0, int[] z1) {

        boolean[] states = new boolean[z0.length];
        Arrays.fill(states, false);

        TreeSet<State> open = new TreeSet<>(comparingInt((State o) -> o.score())
                .thenComparingInt(o -> o.moves.si())
                .thenComparingInt(State::hashCode));

        open.add(State.startState(z0.length));
        Set<State> closed = new HashSet<>();

        while (!open.isEmpty()) {
            State currentState = open.pollFirst();
            closed.add(currentState);

            if (currentState.score() == z0.length) {
                System.out.println("Finished " + currentState + " open " + open.size() + " closed " + closed.size());
                return "Exists";
            }

            currentState.generateMoves()
                    .filter(state -> !closed.contains(state))
                    .forEach(open::add);
        }

        System.out.println("closed " + closed.size());

    }

        return"Does not exist";
}

class State {
    boolean[] states;
    String moves;

    public State(boolean[] states, String moves) {
        this.states = states;
        this.moves = moves;
    }

    int score() {
    }

    public static State startState(int length) {
        return null;
    }

    public Stream<State> generateMoves() {
        return null;
    }
}

}
