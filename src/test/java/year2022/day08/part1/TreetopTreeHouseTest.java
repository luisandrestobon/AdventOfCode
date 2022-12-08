package year2022.day08.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreetopTreeHouseTest {
    private final TreetopTreeHouse treetopTreeHouse = new TreetopTreeHouse();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day08.txt");
        int expected = 21;
        int actual = treetopTreeHouse.countOfTreesVisible(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day08.txt");
        int expected = 1695;
        int actual = treetopTreeHouse.countOfTreesVisible(testList);
        assertEquals(expected, actual);
    }
}
