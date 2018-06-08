package rrabarg.puzzles.cheapesttabcomplete;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Problem Statement
    	You are in a chat room that supports nickname tab-completion. Suppose the input buffer now contains the string s and you decide to use the completion facility.
    	The first time you press tab you will be shown the lexicographically first element of names that has s as a prefix.
    	Pressing tab again will give the lexicographically second, and so forth. Once the possible options are exhausted the tab key will do nothing.
    	Having found a completion that suits you, you may either press enter to complete the word you are typing, or continue typing characters into the input buffer.
    	If you decide to type characters, they will be appended to the current completion. Your goal is to type the word w, followed by the enter key, using as few keystrokes
    	as possible. Each character and each tab key count as single keystrokes. By interchanging character typing and tab completion sequences as many times as you like, return the fewest
    	number of keystrokes required.

Definition

Class:	CheapestTabComplete
Method:	getFewest
Parameters:	String[], String
Returns:	int
Method signature:	int getFewest(String[] names, String w)
(be sure your method is public)


Notes
-	If the buffer is empty, then every element of names is a possible completion for the buffer.
-	The only allowed keystrokes are letters, tabs, and enter.

Constraints
-	names will contain between 0 and 50 elements, inclusive.
-	Each element of names will contain between 1 and 50 lowercase letters ('a'-'z'), inclusive.
-	w will contain between 1 and 50 lowercase letters ('a'-'z'), inclusive.
 */
class CheapestTabComplete {

    private int[] costs;

    public int getFewest(String[] names, String term) {
        costs = new int[term.length()];
        Arrays.sort(names);

        IntStream.range(0, term.length()).forEach(i -> costs[i] = i + 1);

        IntStream.range(0, term.length())
                .mapToObj(i -> term.substring(0, i))
                .forEach(prefix -> applyCompletions(prefix, names, term));

        return costs[term.length() - 1] + 1;
    }

    private void applyCompletions(String prefix, String[] names, String term) {

        int costToHere = "".equals(prefix) ? 0 : costs[prefix.length() - 1];
        List<String> completions = getCompletions(prefix, names);

        for (int count = 0; count < completions.size(); count++) {
            String completion = completions.get(count);
            if (term.startsWith(completion)) {
                int costIndex = completion.length() - 1;
                int completionCost = costToHere + 1 + count;
                for (int i = costIndex; i < costs.length; i++) {
                    costs[i] = Math.min(costs[i], completionCost + i - costIndex);
                }
            }
        }
    }

    private List<String> getCompletions(String prefix, String[] names) {
        return Arrays.stream(names)
                .filter(n -> n.startsWith(prefix))
                .collect(Collectors.toList());
    }

}







