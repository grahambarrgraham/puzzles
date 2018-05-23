package rrabarg.puzzles.ab;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.util.Arrays.fill;


public class ABIterative implements FindKPairsInN {

    public String createString(int n, int k) {

        if (n == 0) {
            return "";
        }

        char[] result = new char[n];

        int firstB = n / 2;

        fill(result, 0, firstB, 'A');
        fill(result, firstB, n, 'B');

        int currentK = firstB * (n - firstB);

        if (currentK < k) {
            return "";
        }

        int lastB = n;

        while (currentK > k) {

            for(int i = firstB; i < lastB; i++) {
                result[i - 1] = 'B';
                result[i] = 'A';
                currentK--;

                if (currentK == k) {
                    break;
                }
            }

            firstB--;
            lastB--;
        }

        return new String(result);
    }

}