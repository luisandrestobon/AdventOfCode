package year2022.day13.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistressSignalTest {
    private final DistressSignal distressSignal = new DistressSignal();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day13.txt");
        int expected = 13;
        int actual = distressSignal.sumPairIndices(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day13.txt");
        int expected = 6420;
        int actual = distressSignal.sumPairIndices(testList);
        assertEquals(expected, actual);
    }
}
