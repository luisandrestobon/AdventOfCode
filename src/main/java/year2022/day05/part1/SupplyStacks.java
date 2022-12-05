package year2022.day05.part1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SupplyStacks {
    public String getTopStackCrate(List<String> testList) {
        List<List<String>> dividedData = divideData(testList);
        List<String> stacksData = dividedData.get(0);
        List<String> orderOfStacksData = dividedData.get(1);
        List<String> movementsData = dividedData.get(2);
        List<Deque<Character>> stacks = createStacks(stacksData, orderOfStacksData);
        for (String movementData : movementsData) {
            int[] movement = extractMovement(movementData);
            executeMovement(stacks, movement);
        }
        return extractTopStackCrate(stacks);
    }

    private List<List<String>> divideData(List<String> testList) {
        List<List<String>> dividedData = new ArrayList<>();
        int divideIndex = 0;
        for (int i = 0; i < testList.size(); i++) {
            if (testList.get(i).isEmpty()) {
                divideIndex = i;
                break;
            }
        }
        dividedData.add(testList.subList(0, divideIndex - 1));
        dividedData.add(testList.subList(divideIndex - 1, divideIndex));
        dividedData.add(testList.subList(divideIndex + 1, testList.size()));
        return dividedData;
    }

    private List<Deque<Character>> createStacks(List<String> stacksData, List<String> orderOfStacksData) {
        String order = orderOfStacksData.get(0);
        List<Deque<Character>> stacks = new ArrayList<>();
        int i = 0;
        int position = 1;
        while (position < order.length()) {
            Deque<Character> deque = new ArrayDeque<>();
            for(int j = stacksData.size() - 1; j >= 0; j--) {
                String stacksRow = stacksData.get(j);
                if (stacksRow.length() - 1 < position) {
                    break;
                }
                char crate = stacksRow.charAt(position);
                if (crate == ' ') {
                    break;
                }
                deque.push(crate);
            }
            stacks.add(deque);
            i++;
            position = 1 + (4 * i);
        }
        return stacks;
    }

    private int[] extractMovement(String movementData) {
        String[] words = movementData.split(" ");
        return new int[]{
                Integer.parseInt(words[1]),
                Integer.parseInt(words[3]),
                Integer.parseInt(words[5])
        };
    }

    private void executeMovement(List<Deque<Character>> stacks, int[] movement) {
        for (int i = 0; i < movement[0]; i++) {
            Deque<Character> stackFrom = stacks.get(movement[1] - 1);
            Deque<Character> stackTo = stacks.get(movement[2] - 1);
            stackTo.push(stackFrom.pop());
        }
    }

    private String extractTopStackCrate(List<Deque<Character>> stacks) {
        StringBuilder topStackCrate = new StringBuilder();
        for (Deque<Character> stack : stacks) {
            if (!stack.isEmpty()) {
                topStackCrate.append(stack.pop());
            }
        }
        return topStackCrate.toString();
    }
}
