package year2021.day12.part1;

import java.util.*;

public class Graph {
    List<GraphNode> graphNodes = new ArrayList<>();

    public Graph(List<String> pairList) {
        for (String pair : pairList) {
            createOrUpdateGraphNodesPair(pair);
        }
    }

    public int getAllPathsFromStartToEnd() {
        Set<GraphNode> visited = new HashSet<>();
        GraphNode start = getGraphNodeByName();
        List<List<GraphNode>> allPaths = getAllPathsFromNode(start, visited);
        return allPaths.size();
    }

    public List<List<GraphNode>> getAllPathsFromNode(GraphNode initial, Set<GraphNode> visited) {
        Set<GraphNode> newVisited = new HashSet<>(visited);
        if (initial.getName().equals("end")) {
            List<GraphNode> list = new ArrayList<>();
            list.add(initial);
            List<List<GraphNode>> lists = new ArrayList<>();
            lists.add(list);
            return lists;
        }
        if (!initial.isBigCave()) {
            newVisited.add(initial);
        }
        List<List<GraphNode>> completeList = new ArrayList<>();
        for (GraphNode neighbor : initial.neighbors) {
            if (visited.contains(neighbor)) {
                continue;
            }
            List<List<GraphNode>> neighborLists = getAllPathsFromNode(neighbor, newVisited);
            if (neighborLists.isEmpty()) {
                continue;
            }
            for (List<GraphNode> list : neighborLists) {
                list.add(0, initial);
            }
            completeList.addAll(neighborLists);
        }
        return completeList;
    }

    private void createOrUpdateGraphNodesPair(String pair) {
        String[] pairArray = pair.split("-");
        GraphNode[] graphNodesArray = new GraphNode[2];
        for (int i = 0; i < graphNodesArray.length; i++) {
            graphNodesArray[i] = new GraphNode(pairArray[i]);
            if (graphNodes.contains(graphNodesArray[i])) {
                graphNodesArray[i] = getGraphNodeByName(graphNodesArray[i]);
            } else {
                graphNodes.add(graphNodesArray[i]);
            }
        }
        graphNodesArray[0].addNeighbor(graphNodesArray[1]);
        graphNodesArray[1].addNeighbor(graphNodesArray[0]);
    }

    private GraphNode getGraphNodeByName() {
        return getGraphNodeByName(new GraphNode("start"));
    }

    private GraphNode getGraphNodeByName(GraphNode graphNode) {
        return graphNodes.get(graphNodes.indexOf(graphNode));
    }
}
