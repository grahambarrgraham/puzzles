package rrabarg.puzzles.abba;

public class Abba implements IsSequencePossible {

    @Override
    public String canObtain(String from, String to) {

        while (to.length() > from.length()) {
            char lastCharacter = getLastCharacter(to);
            to = truncateLastCharacter(to);

            if (lastCharacter == 'B') {
                to = reverse(to);
            }
        }

        if (from.equals(to)) {
            return "Possible";
        } else {
            return "Impossible";
        }
    }

    private char getLastCharacter(String to) {
        return to.charAt(to.length() - 1);
    }

    private String truncateLastCharacter(String to) {
        return to.substring(0, to.length() - 1);
    }

    private String reverse(String from) {
        return new StringBuilder(from).reverse().toString();
    }
}
