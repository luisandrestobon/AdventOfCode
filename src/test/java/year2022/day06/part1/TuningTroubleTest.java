package year2022.day06.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TuningTroubleTest {
    private final TuningTrouble tuningTrouble = new TuningTrouble();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day06.txt");
        int[] expected = { 7, 5, 6, 10, 11 };
        int[] actual = tuningTrouble.numberCharactersNeededList(testList);
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day06.txt");
        int[] expected = { 1804 };
        int[] actual = tuningTrouble.numberCharactersNeededList(testList);
        assertArrayEquals(expected, actual);
    }
}
