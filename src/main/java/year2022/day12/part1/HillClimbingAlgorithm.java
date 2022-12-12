package year2022.day12.part1;

import java.util.List;

public class HillClimbingAlgorithm {
    public int fewestStepsRequired(List<String> testList) {
        Graph graph = new Graph(testList);
        graph.BFSForSSSPP();
        return graph.getEnd().getDistance();
    }
}
