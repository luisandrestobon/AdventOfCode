package year2021.day02.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiveTest {
    private Dive dive = new Dive();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_day02.txt");
        int expected = 900;
        int actual = dive.submarinePositionWithAimProduct(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day02.txt");
        int expected = 2101031224;
        int actual = dive.submarinePositionWithAimProduct(testList);
        assertEquals(expected, actual);
    }
}
