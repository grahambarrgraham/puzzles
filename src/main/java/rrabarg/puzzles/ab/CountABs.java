package rrabarg.puzzles.ab;

public class CountABs {

    public int count(String s) {

        int count = 0;
        int aCount = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case 'A':
                    aCount++;
                    break;
                case 'B':
                    count += aCount;
                    break;
            }
        }

        return count;
    }

}
