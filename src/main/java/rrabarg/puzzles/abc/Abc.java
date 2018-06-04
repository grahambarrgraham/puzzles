package rrabarg.puzzles.abc;

import static java.util.Arrays.fill;

/**
 * Problem Statement
 * You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:
 * <p>
 * The string has exactly N characters, each of which is either 'A', 'B' or 'C'.
 * The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] < s[j]
 * If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
 */
public class Abc implements FindKPairsInN {

    public String createString(int n, int k) {
        if (n == 0) {
            return "";
        }

        String result = "";
        int firstB = n / 3;
        int firstC = 2 * n / 3;
        int currentK = firstB * (firstC - firstB) + (firstC * (n - firstC));

        if (currentK >= k) {

            char[] array = new char[n];

            fill(array, 0, firstB, 'A');
            fill(array, firstB, firstC, 'B');
            fill(array, firstC, n, 'C');

            int lastC = n;

            while (currentK > k && firstC > firstB) {
                for(int i = firstC; i < lastC; i++) {
                    array[i - 1] = 'C';
                    array[i] = 'B';
                    currentK--;

                    if (currentK == k) {
                        break;
                    }
                }

                firstC--;
                lastC--;
            }

            int lastB = n;

            while (currentK > k) {
                for(int i = firstB; i < lastB; i++) {
                    array[i - 1] = array[i];
                    array[i] = 'A';
                    currentK--;

                    if (currentK == k) {
                        break;
                    }
                }

                firstB--;
                lastB--;
            }


            result = new String(array);
        }

        return result;
    }

}