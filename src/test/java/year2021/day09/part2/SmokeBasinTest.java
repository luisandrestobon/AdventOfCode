package year2021.day09.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmokeBasinTest {
    private final SmokeBasin smokeBasin = new SmokeBasin();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_day09.txt");
        int expected = 1134;
        int actual = smokeBasin.obtainBasinSizesGraph(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day09.txt");
        int expected = 891684;
        int actual = smokeBasin.obtainBasinSizesGraph(testList);
        assertEquals(expected, actual);
    }
}
