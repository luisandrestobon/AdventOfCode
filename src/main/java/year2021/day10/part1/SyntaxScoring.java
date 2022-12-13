package year2021.day10.part1;

import java.util.*;

public class SyntaxScoring {
    private final Map<NavChar, NavChar> mapOfChars;
    private final Deque<NavChar> stack = new ArrayDeque<>();

    public SyntaxScoring() {
        this.mapOfChars = new HashMap<>();
        this.mapOfChars.put(NavChar.CLOSE_PARENTHESIS, NavChar.OPEN_PARENTHESIS);
        this.mapOfChars.put(NavChar.CLOSE_SQUARE_BRACKET, NavChar.OPEN_SQUARE_BRACKET);
        this.mapOfChars.put(NavChar.CLOSE_CURLY_BRACKET, NavChar.OPEN_CURLY_BRACKET);
        this.mapOfChars.put(NavChar.CLOSE_GREATER_LESS, NavChar.OPEN_GREATER_LESS);
    }


    public int getTotalSyntaxErrorScore(List<String> testList) {
        return testList.stream().map(this::getCorruptedPoints).filter(Objects::nonNull).map(NavChar::getPoints).reduce(0, Integer::sum);
    }

    private NavChar getCorruptedPoints(String line) {
        NavChar[] navChars = getNavCharArrayFromString(line);
        stack.clear();
        for (NavChar navChar : navChars) {
            if (!mapOfChars.containsKey(navChar)) {
                stack.push(navChar);
            } else if (stack.isEmpty() || stack.pop() != mapOfChars.get(navChar)) {
                return navChar;
            }
        }
        return null;
    }

    private NavChar[] getNavCharArrayFromString(String line) {
        return Arrays.stream(line.split("")).map(NavChar::getNavVarByChr).toArray(NavChar[]::new);
    }


}
