package year2021.day02.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static common.FileModule.file2StringList;

public class DiveTest {
    private Dive dive = new Dive();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_day02.txt");
        int expected = 150;
        int actual = dive.submarinePositionProduct(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day02.txt");
        int expected = 2102357;
        int actual = dive.submarinePositionProduct(testList);
        assertEquals(expected, actual);
    }
}
