package year2022.day10.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CathodeRayTubeTest {
    private final CathodeRayTube cathodeRayTube = new CathodeRayTube();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day10.txt");
        int expected = 13140;
        int actual = cathodeRayTube.sumSignalStrengths(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day10.txt");
        int expected = 14560;
        int actual = cathodeRayTube.sumSignalStrengths(testList);
        assertEquals(expected, actual);
    }
}
