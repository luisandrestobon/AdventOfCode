package year2021.day04;

public class MutableBoolean {
    private Boolean isCrossed;

    public MutableBoolean(Boolean isCrossed) {
        this.isCrossed = isCrossed;
    }

    public Boolean getCrossed() {
        return isCrossed;
    }

    public void setCrossed(Boolean crossed) {
        isCrossed = crossed;
    }

    @Override
    public String toString() {
        return getCrossed().toString();
    }
}

