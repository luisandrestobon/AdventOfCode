package year2023.day01.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static common.FileModule.file2StringList;

public class TrebuchetTest {
    private final Trebuchet trebuchet = new Trebuchet();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2023/test_day01.txt");
        int expected = 142;
        int actual = trebuchet.sumOfCalibrationValues(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2023/input_day01.txt");
        int expected = 56042;
        int actual = trebuchet.sumOfCalibrationValues(testList);
        assertEquals(expected, actual);
    }
}
