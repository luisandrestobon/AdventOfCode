package year2021.day01.part1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SonarSweep {

    private Map<Integer, Integer> cache = new HashMap<>();

    public int countIncreasesMeasurement(List<Integer> input) {
        int output = 0;
        for (int i = 1; i < input.size(); i++) {
            output += (input.get(i-1) < input.get(i) ? 1 : 0);
        }
        return output;
    }
}
