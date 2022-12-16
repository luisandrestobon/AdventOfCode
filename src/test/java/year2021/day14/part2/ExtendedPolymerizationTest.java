package year2021.day14.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtendedPolymerizationTest {
    private final ExtendedPolymerization extendedPolymerization = new ExtendedPolymerization();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_day14.txt");
        long expected = 2188189693529L;
        long actual = extendedPolymerization.mostCommonMinusLeastCommon(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day14.txt");
        long expected = 3816397135460L;
        long actual = extendedPolymerization.mostCommonMinusLeastCommon(testList);
        assertEquals(expected, actual);
    }
}
