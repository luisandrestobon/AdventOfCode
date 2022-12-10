package year2022.day10.part1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CathodeRayTube {
    private final Deque<Integer> addValuesQueue = new ArrayDeque<>();
    public int sumSignalStrengths(List<String> testList) {
        int sumStrengths = 0;
        int registerX = 1;
        int i = 0;
        int j = 0;
        while (!addValuesQueue.isEmpty() || j < testList.size()) {
            if ((i + 21) % 40 == 0) {
                sumStrengths += (i + 1) * registerX;
            }
            if (addValuesQueue.isEmpty()) {
                String[] instruction = testList.get(j++).split(" ");
                if (instruction.length == 1) {
                    // noop
                    // Just one cycle
                    // No value added
                    addValuesQueue.offer(0);
                } else {
                    // addx
                    // First cycle
                    // No value added
                    addValuesQueue.offer(0);
                    // Second cycle
                    // Value added
                    addValuesQueue.offer(Integer.parseInt(instruction[1]));
                }
            }
            registerX += addValuesQueue.isEmpty() ? 0 : addValuesQueue.poll();
            i++;
        }
        return sumStrengths;
    }
}
