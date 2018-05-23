package rrabarg.puzzles.ab;

import java.util.ArrayList;
import java.util.List;


public class ABExhaustive implements FindKPairsInN {

    private final CountABs counter = new CountABs();

    int targetK;

    @Override
    public String createString(int n, int k) {

        targetK = k;

        return generateCombinations(new char[]{'A', 'B'}, n)
                .stream()
                .sorted()
                .filter(s -> counter.count(s) == k)
                .findFirst()
                .orElse("");
    }

    private List<String> generateCombinations(char[] set, int k) {
        List<String> result = new ArrayList<>();
        int n = set.length;
        generateCombinations(set, "", n, k, result);
        return result;
    }

    private void generateCombinations(char[] set, String prefix, int n, int k, List<String> result) {

        if (counter.count(prefix) > targetK) {
            return;
        }

        if (k == 0) {
            result.add(prefix);
            return;
        }

        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i];
            generateCombinations(set, newPrefix, n, k - 1, result);
        }
    }

}