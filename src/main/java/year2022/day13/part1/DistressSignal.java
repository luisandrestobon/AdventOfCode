package year2022.day13.part1;

import java.util.ArrayList;
import java.util.List;

public class DistressSignal {

    private final List<PacketPair> packetPairs = new ArrayList<>();
    private final List<Integer> compareList = new ArrayList<>();

    public int sumPairIndices(List<String> testList) {
        getInitialPacketPairs(testList);
        int index = 1;
        for (PacketPair packetPair : packetPairs) {
            //System.out.println();
            //System.out.println("== Pair " + index + " ==");
            Boolean compare = packetPair.compareSides();
            if (compare == null || compare) {
                compareList.add(index);
            }
            index++;
        }
        return compareList.stream().reduce(0, Integer::sum);
    }

    private void getInitialPacketPairs(List<String> testList) {
        testList.add("");
        List<String> packets = new ArrayList<>();
        for (String line : testList) {
            if (!line.isEmpty()) {
                packets.add(line);
            } else {
                packetPairs.add(new PacketPair(packets));
                packets = new ArrayList<>();
            }
        }
    }
}
