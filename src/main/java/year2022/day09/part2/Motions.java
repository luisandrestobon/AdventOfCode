package year2022.day09.part2;

public enum Motions {
    U(0, 1),
    D(0, -1),
    L(-1, 0),
    R(1, 0);

    private final int deltaX;
    private final int deltaY;

    Motions(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }
}
