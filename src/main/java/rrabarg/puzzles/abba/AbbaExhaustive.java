package rrabarg.puzzles.abba;

public class AbbaExhaustive implements IsSequencePossible {

    @Override
    public String canObtain(String from, String to) {

        if (from == to) {
            return "Possible";
        }

        if (from.length() > to.length()) {
            return "Impossible";
        }

        if (!(to.contains(from) || to.contains(reverse(from)))) {
            return "Impossible";
        }

        return foo(from, to) ? "Possible" : "Impossible";
    }


    boolean foo(String from, String to) {

        String addA = from + "A";
        String addB = reverse(from) + "B";

        if (addA.equals(to) || addB.equals(to)) {
            return true;
        }

        if (from.length() + 1 < to.length()) {
            return foo(addA, to) || foo(addB, to);
        }

        return false;
    }

    private String reverse(String from) {
        return new StringBuilder(from).reverse().toString();
    }
}
