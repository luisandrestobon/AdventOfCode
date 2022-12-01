package year2021.day01.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static common.FileModule.file2IntegerList;

public class SonarSweepTest {

    private SonarSweep sonarSweep = new SonarSweep();

    @Test
    void firstTest() {
        List<Integer> testList = file2IntegerList("src/test/resources/year2021/test_day01.txt");
        int expected = 5;
        int actual = sonarSweep.countIncreasesWindowMeasurement(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<Integer> testList = file2IntegerList("src/test/resources/year2021/input_day01.txt");
        int expected = 1683;
        int actual = sonarSweep.countIncreasesWindowMeasurement(testList);
        assertEquals(expected, actual);
    }

}
