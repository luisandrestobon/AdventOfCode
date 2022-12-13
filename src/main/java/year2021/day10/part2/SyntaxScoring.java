package year2021.day10.part2;

import java.util.*;
import java.util.stream.Collectors;

public class SyntaxScoring {
    private final Map<NavChar, NavChar> mapOfChars;
    private final Map<NavChar, NavChar> inversedMapOfChars;
    private final Deque<NavChar> stack = new ArrayDeque<>();
    private final List<List<NavChar>> incompleteLines = new ArrayList<>();

    public SyntaxScoring() {
        this.mapOfChars = new HashMap<>();
        this.mapOfChars.put(NavChar.CLOSE_PARENTHESIS, NavChar.OPEN_PARENTHESIS);
        this.mapOfChars.put(NavChar.CLOSE_SQUARE_BRACKET, NavChar.OPEN_SQUARE_BRACKET);
        this.mapOfChars.put(NavChar.CLOSE_CURLY_BRACKET, NavChar.OPEN_CURLY_BRACKET);
        this.mapOfChars.put(NavChar.CLOSE_GREATER_LESS, NavChar.OPEN_GREATER_LESS);
        this.inversedMapOfChars = new HashMap<>();
        this.inversedMapOfChars.put(NavChar.OPEN_PARENTHESIS, NavChar.CLOSE_PARENTHESIS);
        this.inversedMapOfChars.put(NavChar.OPEN_SQUARE_BRACKET, NavChar.CLOSE_SQUARE_BRACKET);
        this.inversedMapOfChars.put(NavChar.OPEN_CURLY_BRACKET, NavChar.CLOSE_CURLY_BRACKET);
        this.inversedMapOfChars.put(NavChar.OPEN_GREATER_LESS, NavChar.CLOSE_GREATER_LESS);
    }


    public void getTotalSyntaxErrorScore(List<String> testList) {
        testList.forEach(this::getCorruptedPoints);
    }

    private void getCorruptedPoints(String line) {
        NavChar[] navChars = getNavCharArrayFromString(line);
        List<NavChar> incompleteNavChars = new ArrayList<>();
        stack.clear();
        for (NavChar navChar : navChars) {
            if (!mapOfChars.containsKey(navChar)) {
                stack.push(navChar);
            } else if (stack.isEmpty() || stack.pop() != mapOfChars.get(navChar)) {
                return;
            }
        }
        while (!stack.isEmpty()) {
            incompleteNavChars.add(inversedMapOfChars.get(stack.pop()));
        }
        incompleteLines.add(incompleteNavChars);
    }

    private NavChar[] getNavCharArrayFromString(String line) {
        return Arrays.stream(line.split("")).map(NavChar::getNavVarByChr).toArray(NavChar[]::new);
    }


    public long getMiddleScore(List<String> testList) {
        getTotalSyntaxErrorScore(testList);
        List<Long> list = incompleteLines.stream().map(this::getPointsFromIncompleteList).sorted().collect(Collectors.toList());
        return list.get(list.size() / 2);
    }

    private long getPointsFromIncompleteList(List<NavChar> navChars) {
        return navChars.stream().map(NavChar::getIncompletePoints).reduce(0L, (subTotal, element) -> 5 * subTotal + element);
    }
}
