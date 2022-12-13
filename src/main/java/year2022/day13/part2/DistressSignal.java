package year2022.day13.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistressSignal {

    private static final String FIRST_DIVIDER = "[[2]]";
    private static final String SECOND_DIVIDER = "[[6]]";
    private List<String> packets = new ArrayList<>();
    private final List<String> dividerPackets = Arrays.asList(FIRST_DIVIDER, SECOND_DIVIDER);

    public int getDecoderKey(List<String> testList) {
        getInitialPacketList(testList);
        insertionSortPackets();
        return (packets.indexOf(FIRST_DIVIDER) + 1) * (packets.indexOf(SECOND_DIVIDER) + 1);
    }

    private void getInitialPacketList(List<String> testList) {
        packets.addAll(dividerPackets);
        for (String line : testList) {
            if (!line.isEmpty()) {
                packets.add(line);
            }
        }
    }

    private void insertionSortPackets() {
        String[] array = new String[packets.size()];
        packets.toArray(array);
        for (int i = 1; i < array.length; i++) {
            String key = array[i];
            int j = i - 1;
            while (j >= 0 && isCorrectOrder(key, array[j])) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        packets = Arrays.stream(array).collect(Collectors.toList());
    }

    private boolean isCorrectOrder(String left, String right) {
        PacketPair packetPair = new PacketPair(left, right);
        return packetPair.compareSides();
    }
}
