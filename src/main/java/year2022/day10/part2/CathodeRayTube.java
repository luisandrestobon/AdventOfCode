package year2022.day10.part2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CathodeRayTube {
    private final Deque<Integer> addValuesQueue = new ArrayDeque<>();
    public List<String> getCRTImage(List<String> testList) {
        List<String> crtImage = new ArrayList<>();
        int registerX = 1;
        int i = 0;
        int j = 0;
        int pixel;
        StringBuilder row = new StringBuilder();
        while (!addValuesQueue.isEmpty() || j < testList.size()) {
            if (i != 0 && i % 40 == 0) {
                crtImage.add(row.toString());
                row = new StringBuilder();
            }
            pixel = i % 40;
            row.append((registerX - 1 <= pixel && pixel <= registerX + 1) ? "#" : ".");
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
        crtImage.add(row.toString());
        return crtImage;
    }
}
