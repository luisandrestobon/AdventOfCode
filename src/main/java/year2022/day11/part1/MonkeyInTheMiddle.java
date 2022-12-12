package year2022.day11.part1;

import java.util.*;

public class MonkeyInTheMiddle {

    private static final int NUMBER_OF_ROUNDS = 20;
    public int levelOfMonkeyBusiness(List<String> testList) {
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
        return monkeys;
    }

    private void processRound(List<Monkey> monkeys) {
        for (Monkey monkey : monkeys) {
            Deque<Integer> items = monkey.getItems();
            while (!items.isEmpty()) {
                int item = items.poll();
                item = applyOperation(item, monkey);
                item = item / 3;
                throwToMonkey(item, monkey, monkeys);
                monkey.setCountInspectedItems(monkey.getCountInspectedItems() + 1);
            }
        }
    }

    private Integer applyOperation(Integer item, Monkey monkey) {
        Operators operator = monkey.getOperator();
        Integer operationConstant = monkey.getOperationConstant() == null ? item : monkey.getOperationConstant();
        switch (operator) {
            case SUM:
                return item + operationConstant;
            case MULTIPLY:
                return item * operationConstant;
            default:
                throw new RuntimeException("There is no such operation.");
        }
    }

    private void throwToMonkey(Integer item, Monkey monkey, List<Monkey> monkeys) {
        int testNumber = monkey.getTestNumber();
        boolean whenToThrow = item % testNumber == 0;
        int throwToMonkeyId = monkey.getThrowMonkeyId(whenToThrow);
        Monkey throwToMonkey = monkeys.get(throwToMonkeyId);
        throwToMonkey.getItems().offer(item);
    }
}
