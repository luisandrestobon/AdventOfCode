package year2022.day12.part2;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    private final int i;
    private final int j;
    private final String name;
    private int distance;
    private final char value;
    private Colors color;
    private final List<GraphNode> neighbors = new ArrayList<>();

    public GraphNode(int i, int j, char value) {
        this.i = i;
        this.j = j;
        this.distance = Integer.MAX_VALUE;
        this.name = "" + i + "," + j;
        this.value = value;
        this.color = Colors.WHITE;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public String getName() {
        return name;
    }

    public char getValue() {
        return value;
    }

    public int getIntValue() {
        int intValue = this.value == 'S' ? 'a' : this.value;
        intValue = intValue == 'E' ? 'z' : intValue;
        return intValue;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public List<GraphNode> getNeighbors() {
        return neighbors;
    }
}
