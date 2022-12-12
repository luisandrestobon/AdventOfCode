package year2022.day11.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonkeyInTheMiddleTest {
    private final MonkeyInTheMiddle monkeyInTheMiddle = new MonkeyInTheMiddle();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day11.txt");
        int expected = 10605;
        int actual = monkeyInTheMiddle.levelOfMonkeyBusiness(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day11.txt");
        int expected = 58794;
        int actual = monkeyInTheMiddle.levelOfMonkeyBusiness(testList);
        assertEquals(expected, actual);
    }
}
