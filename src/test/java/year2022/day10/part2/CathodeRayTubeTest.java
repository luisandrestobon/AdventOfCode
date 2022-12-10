package year2022.day10.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CathodeRayTubeTest {
    private final CathodeRayTube cathodeRayTube = new CathodeRayTube();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day10.txt");
        List<String> expected = file2StringList("src/test/resources/year2022/expected_test_day10.txt");
        List<String> actual = cathodeRayTube.getCRTImage(testList);
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
        assertTrue(actual.containsAll(expected));
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day10.txt");
        List<String> expected = file2StringList("src/test/resources/year2022/expected_input_day10.txt");
        List<String> actual = cathodeRayTube.getCRTImage(testList);
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
        assertTrue(actual.containsAll(expected));
    }
}
