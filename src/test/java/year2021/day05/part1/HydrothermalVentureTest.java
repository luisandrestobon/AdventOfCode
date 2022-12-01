package year2021.day05.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HydrothermalVentureTest {

    private HydrothermalVenture hydrothermalVenture = new HydrothermalVenture();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_day05.txt");
        long expected = 5L;
        long actual = hydrothermalVenture.numberOfOverlapPoints(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day05.txt");
        long expected = 6311L;
        long actual = hydrothermalVenture.numberOfOverlapPoints(testList);
        assertEquals(expected, actual);
    }
}
