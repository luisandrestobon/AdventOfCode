package year2022.day07.part1;

import java.util.List;
import java.util.Objects;

public class Node {
    private Node parent;
    private List<Node> childs;
    private final String name;
    private long size;
    private final boolean isDirectory;

    public Node(String name, long size, boolean isDirectory) {
        this.name = name;
        this.size = size;
        this.isDirectory = isDirectory;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChilds() {
        return childs;
    }

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(parent, node.parent) && name.equals(node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, name);
    }
}
