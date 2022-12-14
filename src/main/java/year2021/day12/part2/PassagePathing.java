package year2021.day12.part2;

import java.util.List;

public class PassagePathing {
    public int numborOfPathsSmallCavesTwice(List<String> testList) {
        Graph graph = new Graph(testList);
        return graph.getAllPathsFromStartToEnd();
    }
}
