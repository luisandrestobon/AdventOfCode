package year2022.day09.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RopeBridgeTest {
    private final RopeBridge ropeBridge = new RopeBridge();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day09.txt");
        int expected = 13;
        int actual = ropeBridge.positionsVisitedAtLeastOnce(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day09.txt");
        int expected = 6314;
        int actual = ropeBridge.positionsVisitedAtLeastOnce(testList);
        assertEquals(expected, actual);
    }
}
