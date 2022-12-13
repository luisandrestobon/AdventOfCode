package year2022.day13.part1;

import java.util.ArrayList;
import java.util.List;

public class DistressSignal {

    private final List<PackagePair> packagePairs = new ArrayList<>();
    private final List<Integer> compareList = new ArrayList<>();

    public int sumPairIndices(List<String> testList) {
        getInitialPackagePairs(testList);
        int index = 1;
        for (PackagePair packagePair : packagePairs) {
            //System.out.println();
            //System.out.println("== Pair " + index + " ==");
            Boolean compare = packagePair.compareSides();
            if (compare == null || compare) {
                compareList.add(index);
            }
            index++;
        }
        return compareList.stream().reduce(0, Integer::sum);
    }

    private void getInitialPackagePairs(List<String> testList) {
        testList.add("");
        List<String> packages = new ArrayList<>();
        for (String line : testList) {
            if (!line.isEmpty()) {
                packages.add(line);
            } else {
                packagePairs.add(new PackagePair(packages));
                packages = new ArrayList<>();
            }
        }
    }
}
