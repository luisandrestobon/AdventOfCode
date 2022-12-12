package year2022.day12.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HillClimbingAlgorithmTest {
    private final HillClimbingAlgorithm hillClimbingAlgorithm = new HillClimbingAlgorithm();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day12.txt");
        int expected = 29;
        int actual = hillClimbingAlgorithm.fewestStepsRequired(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day12.txt");
        int expected = 363;
        int actual = hillClimbingAlgorithm.fewestStepsRequired(testList);
        assertEquals(expected, actual);
    }
}
