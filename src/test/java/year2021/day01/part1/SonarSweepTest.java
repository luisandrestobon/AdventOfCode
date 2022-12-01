package year2021.day01.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static common.FileModule.file2IntegerList;

public class SonarSweepTest {
    private SonarSweep sonarSweep = new SonarSweep();

    @Test
    void firstTest() {
        List<Integer> testList = file2IntegerList("src/test/resources/year2021/test_day01.txt");
        int expected = 7;
        int actual = sonarSweep.countIncreasesMeasurement(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<Integer> testList = file2IntegerList("src/test/resources/year2021/input_day01.txt");
        int expected = 1655;
        int actual = sonarSweep.countIncreasesMeasurement(testList);
        assertEquals(expected, actual);
    }
}
