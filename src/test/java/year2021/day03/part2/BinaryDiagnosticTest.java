package year2021.day03.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryDiagnosticTest {
    private BinaryDiagnostic binaryDiagnostic = new BinaryDiagnostic();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_day03.txt");
        int expected = 230;
        int actual = binaryDiagnostic.lifeSupportRating(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day03.txt");
        int expected = 4996233;
        int actual = binaryDiagnostic.lifeSupportRating(testList);
        assertEquals(expected, actual);
    }
}
