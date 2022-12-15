package year2021.day13.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransparentOrigamiTest {
    private final TransparentOrigami transparentOrigami = new TransparentOrigami();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_day13.txt");
        List<String> expected = file2StringList("src/test/resources/year2021/expected_test_day13.txt");
        List<String> actual = transparentOrigami.visibleDots(testList);
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
        assertTrue(actual.containsAll(expected));
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day13.txt");
        List<String> expected = file2StringList("src/test/resources/year2021/expected_input_day13.txt");
        List<String> actual = transparentOrigami.visibleDots(testList);
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
        assertTrue(actual.containsAll(expected));
    }
}
