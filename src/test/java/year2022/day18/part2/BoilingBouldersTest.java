package year2022.day18.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoilingBouldersTest {
    private final BoilingBoulders boilingBoulders = new BoilingBoulders();

    @Test
    void secondTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_2_day18.txt");
        int expected = 58;
        int actual = boilingBoulders.surfaceAreaLavaDroplet(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day18.txt");
        //int expected = 3496;
        //int expected = 3292;
        int expected = 2064;
        int actual = boilingBoulders.surfaceAreaLavaDroplet(testList);
        assertEquals(expected, actual);
    }
}
