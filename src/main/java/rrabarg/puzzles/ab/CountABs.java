package rrabarg.puzzles.ab;

public class CountABs {

    public int count(String s) {

        int count = 0;
        int aCount = 0;
        int bCount = 0;
        char lastChar = '0';

        for (char c : s.toCharArray()) {
            if ('A' == c) {

                if (lastChar == 'B') {
                    count += aCount * bCount;
                    bCount = 0;
                }
                aCount++;

            } else {
                bCount++;
            }

            lastChar = c;
        }

        count += aCount * bCount;

        return count;
    }

}
