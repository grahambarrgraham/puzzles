package rrabarg.puzzles.cheapesttabcomplete;

import java.util.*;

class CheapestTabComplete {

    private List<String> names = new ArrayList<>();
    private String term;
    private int minCost;

    public int getFewest(String[] names, String term) {
        this.names.addAll(Arrays.asList(names));
        this.names.sort(Comparator.naturalOrder());
        this.term = term;
        this.minCost = term.length();

        generateStates(new State(0, "", 0));

        return minCost + 1;
    }

    void generateStates(State state) {

        if (state == null || !term.startsWith(state.term)) {
            return;
        }

        if (state.term.equals(term) && state.cost < minCost) {
            minCost = state.cost;
        }

        generateStates(nextChar(state));
        generateStates(pressTab(state));
    }

    private State pressTab(final State state) {

        for (int i = state.index; i < names.size(); i++) {
            if (names.get(i).startsWith(state.term)) {
                return new State(i + 1, names.get(i), state.cost + 1);
            }
        }

        return null;
    }

    private State nextChar(State currentState) {

        if (currentState.term.length() >= term.length()) {
            return null;
        }

        String nextTerm = currentState.term + this.term.charAt(currentState.term.length());
        return new State(currentState.index, nextTerm, currentState.cost + 1);
    }

    class State {
        private final int index;
        String term;
        int cost;

        public State(int index, String term, int cost) {
            this.index = index;
            this.term = term;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return String.format("%s[%s]:%s", term, index, cost);
        }
    }

}







