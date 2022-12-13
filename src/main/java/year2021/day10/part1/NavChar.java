package year2021.day10.part1;

public enum NavChar {
    OPEN_PARENTHESIS("(", 0),
    CLOSE_PARENTHESIS(")", 3),
    OPEN_SQUARE_BRACKET("[", 0),
    CLOSE_SQUARE_BRACKET("]", 57),
    OPEN_CURLY_BRACKET("{", 0),
    CLOSE_CURLY_BRACKET("}", 1197),
    OPEN_GREATER_LESS("<", 0),
    CLOSE_GREATER_LESS(">", 25137);

    private final String chr;
    private final int points;

    NavChar(String chr, int points) {
        this.chr = chr;
        this.points = points;
    }

    public String getChr() {
        return chr;
    }

    public int getPoints() {
        return points;
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
