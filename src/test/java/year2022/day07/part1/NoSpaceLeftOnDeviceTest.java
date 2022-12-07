package year2022.day07.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoSpaceLeftOnDeviceTest {
    private final NoSpaceLeftOnDevice noSpaceLeftOnDevice2 = new NoSpaceLeftOnDevice();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day07.txt");
        long expected = 95437L;
        long actual = noSpaceLeftOnDevice2.sumDirectoriesTotalSizes(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day07.txt");
        long expected = 1428881L;
        long actual = noSpaceLeftOnDevice2.sumDirectoriesTotalSizes(testList);
        assertEquals(expected, actual);
    }
}
