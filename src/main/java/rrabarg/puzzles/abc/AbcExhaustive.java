package rrabarg.puzzles.abc;

import java.util.ArrayList;
import java.util.List;


public class AbcExhaustive implements FindKPairsInN {

    private final CountABCs counter = new CountABCs();

    int targetK;

    @Override
    public String createString(int n, int k) {

        targetK = k;

        return generateCombinations(new char[]{'A', 'B', 'C'}, n)
                .stream()
                .sorted()
                .filter(s -> counter.count(s) == k)
                .findFirst()
                .orElse("");
    }

    private List<String> generateCombinations(char[] set, int stringLength) {
        List<String> result = new ArrayList<>();
        generateCombinations(set, "", stringLength, result);
        return result;
    }

    private void generateCombinations(char[] set, String prefix, int stringLength, List<String> result) {

        if (counter.count(prefix) > targetK) {
            return;
        }

        if (stringLength == 0) {
            result.add(prefix);
            return;
        }

        for (int i = 0; i < set.length; ++i) {
            String newPrefix = prefix + set[i];
            generateCombinations(set, newPrefix, stringLength - 1, result);
        }
    }

}