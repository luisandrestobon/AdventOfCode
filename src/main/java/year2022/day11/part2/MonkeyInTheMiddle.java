package year2022.day11.part2;

import java.util.*;
import java.util.stream.Collectors;

public class MonkeyInTheMiddle {

    private static final int NUMBER_OF_ROUNDS = 10000;

    public long levelOfMonkeyBusinessWithoutRelief(List<String> testList) {
        List<Monkey> monkeys = initializeMonkeyList(testList);
        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            processRound(monkeys);
        }
        monkeys.sort(Comparator.comparing(Monkey::getCountInspectedItems).reversed());
        return monkeys.get(0).getCountInspectedItems() * monkeys.get(1).getCountInspectedItems();
    }

    private List<Monkey> initializeMonkeyList(List<String> testList) {
        List<Monkey> monkeys = new ArrayList<>();
        testList.add("");
        List<String> notes = new ArrayList<>();
        for (String line : testList) {
            if (!line.isEmpty()) {
                notes.add(line);
            } else {
                monkeys.add(new Monkey(notes));
                notes = new ArrayList<>();
            }
        }
        List<Integer> testNumbers = monkeys.stream().map(Monkey::getTestNumber).collect(Collectors.toList());
        for (Monkey monkey : monkeys) {
            monkey.setItems(monkey.getInitialValues().stream().map(v -> new Item(v, testNumbers)).collect(Collectors.toCollection(ArrayDeque::new)));
        }
        return monkeys;
    }

    private void processRound(List<Monkey> monkeys) {
        for (Monkey monkey : monkeys) {
            Deque<Item> items = monkey.getItems();
            while (!items.isEmpty()) {
                Item item = items.poll();
                item.applyOperationAndTest(monkey.getOperator(), monkey.getOperationConstant());
                throwToMonkey(item, monkey, monkeys);
                monkey.setCountInspectedItems(monkey.getCountInspectedItems() + 1L);
            }
        }
    }

    private void throwToMonkey(Item item, Monkey monkey, List<Monkey> monkeys) {
        int testNumber = monkey.getTestNumber();
        Map<Integer, Integer> modulusMap = item.getModulusMap();
        boolean whenToThrow = modulusMap.get(testNumber).equals(0);
        int throwToMonkeyId = monkey.getThrowMonkeyId(whenToThrow);
        Monkey throwToMonkey = monkeys.get(throwToMonkeyId);
        throwToMonkey.getItems().offer(item);
    }
}
