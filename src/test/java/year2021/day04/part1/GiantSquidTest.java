package year2021.day04.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GiantSquidTest {

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_day04.txt");
        GiantSquid giantSquid = new GiantSquid(testList);
        giantSquid.start();
        int expected = 4512;
        int actual = giantSquid.getFinalScore();
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day04.txt");
        GiantSquid giantSquid = new GiantSquid(testList);
        giantSquid.start();
        int expected = 44088;
        int actual = giantSquid.getFinalScore();
        assertEquals(expected, actual);
    }
}
