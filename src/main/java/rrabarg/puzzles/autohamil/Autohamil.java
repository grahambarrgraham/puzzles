package rrabarg.puzzles.autohamil;

import java.util.stream.IntStream;

public class Autohamil {

    public String check(int[] z0, int[] z1) {

        int[] lastStates = {0};

        while (lastStates.length < z0.length) {

            int[] newStates = IntStream.of(lastStates)
                    .flatMap(s -> IntStream.of(s, z0[s], z1[s]))
                    .distinct()
                    .toArray();

            if (newStates.length == lastStates.length) {
                return "Does not exist";
            }

            lastStates = newStates;
        }

        return "Exists";
    }

}

