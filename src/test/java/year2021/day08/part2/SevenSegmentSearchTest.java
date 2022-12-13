package year2021.day08.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SevenSegmentSearchTest {
    private final SevenSegmentSearch sevenSegmentSearch = new SevenSegmentSearch();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_day08.txt");
        int expected = 61229;
        int actual = sevenSegmentSearch.addAllOutputValues(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day08.txt");
        int expected = 974512;
        int actual = sevenSegmentSearch.addAllOutputValues(testList);
        assertEquals(expected, actual);
    }
}
