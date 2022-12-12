package year2022.day11.part2;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Monkey {
    private long countInspectedItems;
    private final List<Integer> initialValues;
    private Deque<Item> items;
    private final Operators operator;
    private final Integer operationConstant;
    private final int testNumber;
    private final int throwMonkeyIdWhenTrue;
    private final int throwMonkeyIdWhenFalse;

    public Monkey(List<String> notes) {
        this.countInspectedItems = 0;
        this.initialValues = extractInitialValues(notes);
        this.operator = extractOperator(notes);
        this.operationConstant = extractOperationConstant(notes);
        this.testNumber = extractTestNumber(notes);
        this.throwMonkeyIdWhenTrue = extractThrowMonkeyId(notes, true);
        this.throwMonkeyIdWhenFalse = extractThrowMonkeyId(notes, false);
    }

    private List<Integer> extractInitialValues(List<String> notes) {
        return Arrays.stream(notes.get(1).split(":")[1].replace(" ", "").split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private Operators extractOperator(List<String> notes) {
        return Operators.getBySymbol(extractOperation(notes)[1]);
    }

    private Integer extractOperationConstant(List<String> notes) {
        String constant = extractOperation(notes)[2];
        return constant.equals("old") ? null : Integer.parseInt(constant);
    }

    private String[] extractOperation(List<String> notes) {
        return notes.get(2).split("=")[1].trim().split(" ");
    }

    private int extractTestNumber(List<String> notes) {
        return Integer.parseInt(notes.get(3).trim().replace("Test: divisible by ", ""));
    }

    private int extractThrowMonkeyId(List<String> notes, boolean whenToThrow) {
        String[] words = whenToThrow ? notes.get(4).split(" ") : notes.get(5).split(" ");
        return Integer.parseInt(words[words.length - 1]);
    }

    public long getCountInspectedItems() {
        return countInspectedItems;
    }

    public void setCountInspectedItems(long countInspectedItems) {
        this.countInspectedItems = countInspectedItems;
    }

    public List<Integer> getInitialValues() {
        return initialValues;
    }

    public Deque<Item> getItems() {
        return items;
    }

    public void setItems(Deque<Item> items) {
        this.items = items;
    }

    public Operators getOperator() {
        return operator;
    }

    public Integer getOperationConstant() {
        return operationConstant;
    }

    public int getTestNumber() {
        return testNumber;
    }

    public int getThrowMonkeyId(boolean whenToThrow) {
        return whenToThrow ? this.throwMonkeyIdWhenTrue : this.throwMonkeyIdWhenFalse;
    }
}
