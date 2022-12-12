package year2022.day12.part2;

import java.util.List;

public class HillClimbingAlgorithm {
    public int fewestStepsRequired(List<String> testList) {
        Graph graph = new Graph(testList);
        int minSteps = Integer.MAX_VALUE;
        for (GraphNode start : graph.getStartList()) {
            graph.BFSForSSSPP(start);
            minSteps = Math.min(graph.getEnd().getDistance(), minSteps);
        }
        return minSteps;
    }
}
