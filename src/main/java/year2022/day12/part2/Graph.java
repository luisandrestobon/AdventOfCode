package year2022.day12.part2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Graph {
    private final List<GraphNode> startList = new ArrayList<>();
    private GraphNode end;
    private final List<GraphNode> nodeList = new ArrayList<>();

    public Graph(List<String> testList) {
        char[][] matrix = createCharMatrix(testList);
        createGraphNodes(matrix);
        assignGraphNodeLinks(matrix);
    }

    public GraphNode getEnd() {
        return end;
    }

    public List<GraphNode> getStartList() {
        return startList;
    }

    private char[][] createCharMatrix(List<String> testList) {
        char[][] matrix = new char[testList.size()][testList.get(0).length()];
        for (int i = 0; i < testList.size(); i++) {
            matrix[i] = testList.get(i).toCharArray();
        }
        return matrix;
    }

    private void createGraphNodes(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nodeList.add(new GraphNode(i, j, matrix[i][j]));
            }
        }
    }

    private void assignGraphNodeLinks(char[][] matrix) {
        for (GraphNode graphNode : this.nodeList) {
            if (graphNode.getValue() == 'a' || graphNode.getValue() == 'S') {
                this.startList.add(graphNode);
            }
            if (graphNode.getValue() == 'E') {
                this.end = graphNode;
            }
            // Up
            int i = graphNode.getI() - 1;
            int j = graphNode.getJ();
            if (i >= 0) {
                assignValidNeighbor(graphNode, i, j, matrix);
            }

            // Right
            i = graphNode.getI();
            j = graphNode.getJ() + 1;
            if (j < matrix[0].length) {
                assignValidNeighbor(graphNode, i, j, matrix);
            }

            // Down
            i = graphNode.getI() + 1;
            j = graphNode.getJ();
            if (i < matrix.length) {
                assignValidNeighbor(graphNode, i, j, matrix);
            }

            // Left
            i = graphNode.getI();
            j = graphNode.getJ() - 1;
            if (j >= 0) {
                assignValidNeighbor(graphNode, i, j, matrix);
            }
        }
    }

    private void assignValidNeighbor(GraphNode actual, int i, int j, char[][] matrix) {
        GraphNode neighbor = nodeList.get(getIndexFromCoordinates(i, j, matrix));
        if (actual.getIntValue() >= neighbor.getIntValue() - 1) {
            actual.getNeighbors().add(neighbor);
        }
    }

    private int getIndexFromCoordinates(int i, int j, char[][] matrix) {
        return j + (i * matrix[0].length);
    }

    public void BFSForSSSPP(GraphNode start) {
        clearGraph();
        Deque<GraphNode> queue = new ArrayDeque<>();
        start.setColor(Colors.GRAY);
        start.setDistance(0);
        queue.offer(start);
        while(!queue.isEmpty()) {
            GraphNode actual = queue.poll();
            for (GraphNode neighbor : actual.getNeighbors()) {
                if (neighbor.getColor().equals(Colors.WHITE)) {
                    neighbor.setColor(Colors.GRAY);
                    neighbor.setDistance(actual.getDistance() + 1);
                    queue.offer(neighbor);
                }
            }
            actual.setColor(Colors.BLACK);
        }
    }

    private void clearGraph() {
        for (GraphNode graphNode : nodeList) {
            graphNode.setColor(Colors.WHITE);
            graphNode.setDistance(Integer.MAX_VALUE);
        }
    }
}
