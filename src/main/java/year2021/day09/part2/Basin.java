package year2021.day09.part2;

import java.util.HashSet;
import java.util.Set;

public class Basin {
    private final int value;
    private int size;
    private Set<String> seen = new HashSet<>();

    public Basin(int value) {
        this.value = value;
    }

    public int getSize() {
        return size;
    }

    public void setSeen(Set<String> seen) {
        this.seen = seen;
        this.size = seen.size();
    }

    @Override
    public String toString() {
        return "Basin{" +
                "value=" + value +
                ", size=" + size +
                ", seen=" + seen +
                '}';
    }
}
