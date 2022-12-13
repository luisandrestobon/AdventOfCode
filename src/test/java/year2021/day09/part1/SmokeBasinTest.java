package year2021.day09.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmokeBasinTest {
    private final SmokeBasin smokeBasin = new SmokeBasin();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_day09.txt");
        int expected = 15;
        int actual = smokeBasin.sumRiskLevels(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day09.txt");
        int expected = 566;
        int actual = smokeBasin.sumRiskLevels(testList);
        assertEquals(expected, actual);
    }
}
