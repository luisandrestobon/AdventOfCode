package year2022.day11.part1;

public enum Operators {
    SUM, MULTIPLY;
    public static Operators getBySymbol(String symbol) {
        switch (symbol) {
            case "+":
                return SUM;
            case "*":
                return MULTIPLY;
            default:
                throw new RuntimeException("There is no such symbol.");
        }
    }
}
