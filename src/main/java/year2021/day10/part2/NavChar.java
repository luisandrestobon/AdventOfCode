package year2021.day10.part2;

public enum NavChar {
    OPEN_PARENTHESIS("(", 0L),
    CLOSE_PARENTHESIS(")", 1L),
    OPEN_SQUARE_BRACKET("[", 0L),
    CLOSE_SQUARE_BRACKET("]", 2L),
    OPEN_CURLY_BRACKET("{", 0L),
    CLOSE_CURLY_BRACKET("}", 3L),
    OPEN_GREATER_LESS("<", 0L),
    CLOSE_GREATER_LESS(">", 4L);

    private final String chr;
    private final long incompletePoints;

    NavChar(String chr, long incompletePoints) {
        this.chr = chr;
        this.incompletePoints = incompletePoints;
    }

    public String getChr() {
        return chr;
    }

    public long getIncompletePoints() {
        return incompletePoints;
    }

    public static NavChar getNavVarByChr(String chr) {
        for (NavChar navChar : NavChar.values()) {
            if (navChar.getChr().equals(chr)) {
                return navChar;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return chr;
    }
}
