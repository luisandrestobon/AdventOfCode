package year2021.day12.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphNode {
    private final String name;

    public List<GraphNode> neighbors = new ArrayList<>();

    public GraphNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNeighbor(GraphNode neighbor) {
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
        }
    }

    public boolean isBigCave() {
        return Character.isUpperCase(this.name.charAt(0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return name.equals(graphNode.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        StringBuilder neighborsSB = new StringBuilder();
        for (GraphNode graphNode : neighbors) {
            neighborsSB.append(graphNode.name);
            neighborsSB.append(" ");
        }
        return "GraphNode{" +
                "name= " + name +
                ", neighbors= " + neighborsSB +
                ", isBigCave= " + isBigCave() +
                '}';
    }

    public static void main(String[] args) {
        GraphNode gn1 = new GraphNode("A");
        GraphNode gn2 = new GraphNode("start");
        GraphNode gn3 = new GraphNode("C");
        GraphNode gn4 = new GraphNode("C");
        gn1.addNeighbor(gn2);
        gn1.addNeighbor(gn3);
        gn1.addNeighbor(gn2);
        gn1.addNeighbor(gn4);
    }
}
