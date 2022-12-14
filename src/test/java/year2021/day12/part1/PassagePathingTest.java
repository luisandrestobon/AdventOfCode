package year2021.day12.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassagePathingTest {
    private final PassagePathing passagePathing = new PassagePathing();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_1_day12.txt");
        int expected = 10;
        int actual = passagePathing.numberOfPathsSmallCavesOnce(testList);
        assertEquals(expected, actual);
    }

    @Test
    void secondTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_2_day12.txt");
        int expected = 19;
        int actual = passagePathing.numberOfPathsSmallCavesOnce(testList);
        assertEquals(expected, actual);
    }

    @Test
    void thirdTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_3_day12.txt");
        int expected = 226;
        int actual = passagePathing.numberOfPathsSmallCavesOnce(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day12.txt");
        int expected = 4885;
        int actual = passagePathing.numberOfPathsSmallCavesOnce(testList);
        assertEquals(expected, actual);
    }
}
