package rrabarg.puzzles.cheapesttabcomplete;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CheapestTabComplete {

    private int[] costs;

    public int getFewest(String[] names, String term) {
        costs = new int[term.length()];
        Arrays.sort(names);

        IntStream.range(0, term.length()).forEach(i -> costs[i] = i + 1);

        Stream<String> prefixStream = IntStream.range(0, term.length()).mapToObj(i -> term.substring(0, i));

        prefixStream.forEach(prefix -> doTabs(prefix, names, term));

        return costs[term.length() -1] + 1;

    }

    private void doTabs(String prefix, String[] names, String term) {

        int costToHere = "".equals(prefix) ? 0 : costs[prefix.length() -1];
        String[] tabs = genTabs(prefix, names);

        for(int tabCount = 0; tabCount < tabs.length; tabCount++) {
            String tabPrefix = tabs[tabCount];
            if (term.startsWith(tabPrefix)) {
                int costIndex = tabPrefix.length() - 1;
                int tabCost = costToHere + 1 + tabCount;
                for (int i = costIndex; i < costs.length; i++) {
                    costs[i] = Math.min(costs[i], tabCost + i  - costIndex);
                }
            }
        }
    }

    private String[] genTabs(String prefix, String[] names) {
        List<String> collect = Arrays.stream(names).filter(n -> n.startsWith(prefix)).collect(Collectors.toList());
        return collect.toArray(new String[collect.size()]);
    }

}







