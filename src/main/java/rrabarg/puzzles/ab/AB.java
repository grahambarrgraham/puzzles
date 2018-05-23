package rrabarg.puzzles.ab;

import static java.util.Arrays.fill;

/**
 Problem Statement
 You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:

 The string has exactly N characters, each of which is either 'A' or 'B'.
 The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
 If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
 */
public class AB implements FindKPairsInN {

    public String createString(int n, int k) {

        if (n == 0) {
            return "";
        }

        String result = "";
        int firstB = n / 2;
        int currentK = firstB * (n - firstB);

        if (currentK >= k) {

            char[] array = new char[n];

            fill(array, 0, firstB, 'A');
            fill(array, firstB, n, 'B');

            if (currentK > k) {
                int numberOfAsToEnd = (currentK - k) / (n - firstB);
                int aInBsIndex = (currentK - k) % (n - firstB);

                fill(array, n - numberOfAsToEnd, n, 'A');
                fill(array, firstB - numberOfAsToEnd, firstB, 'B');

                firstB -= numberOfAsToEnd;

                if (aInBsIndex > 0) {
                    array[firstB - 1] = 'B';
                    array[firstB + aInBsIndex - 1] = 'A';
                }
            }

            result = new String(array);
        }

        return result;
    }

}