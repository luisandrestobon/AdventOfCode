package year2022.day04.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CampCleanupTest {

    private final CampCleanup campCleanup = new CampCleanup();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day04.txt");
        int expected = 2;
        int actual = campCleanup.assignmentPairsCount(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day04.txt");
        int expected = 448;
        int actual = campCleanup.assignmentPairsCount(testList);
        assertEquals(expected, actual);
    }
}
