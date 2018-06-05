package rrabarg.puzzles.cheapesttabcomplete;

import lombok.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CheapestTabComplete {

    TreeNode prefixTree = null;

    public int getFewest(String[] names, String w) {

        Arrays.stream(names).forEach(n -> addName(n));
        String[] prefixes = getPrefixes(w);

        int currentBest = w.length() + 1;

        for(int tapPressCount = 1; tapPressCount < prefixes.length - 1; tapPressCount++) {
            int keyPresses = (w.length() - prefixes[tapPressCount - 1].length()) + 1 + tapPressCount;
            if (keyPresses < currentBest) {
                currentBest = keyPresses;
            }
        }

        return currentBest;
    }

    void addName(String name) {
        if (prefixTree == null) {
            prefixTree = new TreeNode(null,"name", new ArrayList<>());
        }
    }

    String[] getPrefixes(String term) {
        return new String[] {term};
    }


    @Value
    class TreeNode {
        TreeNode parent;
        String prefix;
        List<TreeNode> children;
    }
}




