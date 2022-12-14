package year2021.day12.part1;

import java.util.List;

public class PassagePathing {
    public int numberOfPathsSmallCavesOnce(List<String> testList) {
        Graph graph = new Graph(testList);
        return graph.getAllPathsFromStartToEnd();
    }
}
