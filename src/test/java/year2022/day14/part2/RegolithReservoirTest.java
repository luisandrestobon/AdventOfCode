package year2022.day14.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegolithReservoirTest {
    private final RegolithReservoir regolithReservoir = new RegolithReservoir();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day14.txt");
        int expected = 93;
        int actual = regolithReservoir.unitsOfSandRestWithFloor(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day14.txt");
        int expected = 24958;
        int actual = regolithReservoir.unitsOfSandRestWithFloor(testList);
        assertEquals(expected, actual);
    }
}
