package year2021.day01.part2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SonarSweep {
    private Map<Integer, Integer> cache = new HashMap<>();

    public int countIncreasesWindowMeasurement(List<Integer> input) {
        int output = 0;
        for (int i = 1; i < input.size() - 2; i++) {
            if (!cache.containsKey(i-1)) {
                cache.put(i-1, input.get(i-1) + input.get(i) + input.get(i+1));
            }
            if (!cache.containsKey(i)) {
                cache.put(i, input.get(i) + input.get(i+1) + input.get(i+2));
            }
            output += (cache.get(i-1) < cache.get(i) ? 1 : 0);
        }
        return output;
    }
}
