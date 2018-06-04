package rrabarg.puzzles.abc;

public class CountABCs {

    public int count(String s) {

        int abcCount = 0;
        int aCount = 0;
        int bCount = 0;

        for (char c : s.toCharArray()) {

            switch(c) {
                case 'A' :
                    aCount++;
                    break;
                case 'B' :
                    bCount++;
                    abcCount += aCount;
                    break;
                case 'C' :
                    abcCount += aCount;
                    abcCount += bCount;
                    break;
            }
        }

        return abcCount;
    }

}
