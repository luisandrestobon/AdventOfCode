package year2021.day12.part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    List<GraphNode> graphNodes = new ArrayList<>();

    public Graph(List<String> pairList) {
        for (String pair : pairList) {
            createOrUpdateGraphNodesPair(pair);
        }
    }

    public int getAllPathsFromStartToEnd() {
        Map<GraphNode, Integer> visited = new HashMap<>();
        GraphNode start = getGraphNodeByName();
        boolean isSingleCaveVisitedTwice = false;
        List<List<GraphNode>> allPaths = getAllPathsFromNode(start, visited, isSingleCaveVisitedTwice);
        return allPaths.size();
    }

    public List<List<GraphNode>> getAllPathsFromNode(GraphNode initial, Map<GraphNode, Integer> visited, boolean isSingleCaveVisitedTwice) {
        Map<GraphNode, Integer> newVisited = new HashMap<>(visited);
        if (initial.getName().equals("end")) {
            List<GraphNode> list = new ArrayList<>();
            list.add(initial);
            List<List<GraphNode>> lists = new ArrayList<>();
            lists.add(list);
            return lists;
        }
        if (!initial.isBigCave()) {
            if (isSingleCaveVisitedTwice || initial.getName().equals("start") || initial.getName().equals("end")) {
                newVisited.put(initial, 2);
            } else if ((newVisited.containsKey(initial) && newVisited.get(initial) == 1)) {
                newVisited.put(initial, 2);
                isSingleCaveVisitedTwice = true;
            } else {
                newVisited.put(initial, 1);
            }
        }
        List<List<GraphNode>> completeList = new ArrayList<>();
        for (GraphNode neighbor : initial.neighbors) {
            if (newVisited.containsKey(neighbor) && newVisited.get(neighbor) == 2) {
                continue;
            }
            if (newVisited.containsKey(neighbor) && isSingleCaveVisitedTwice) {
                continue;
            }
            List<List<GraphNode>> neighborLists = getAllPathsFromNode(neighbor, newVisited, isSingleCaveVisitedTwice);
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
