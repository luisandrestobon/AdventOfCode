package year2022.day09.part1;

public class Movement {
    private final Motions motion;
    private final int steps;

    public Movement(String[] array) {
        this.motion = Motions.valueOf(array[0]);
        this.steps = Integer.parseInt(array[1]);
    }

    public Motions getMotion() {
        return motion;
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "Movement{" +
                "motion=" + motion +
                ", steps=" + steps +
                '}';
    }
}
