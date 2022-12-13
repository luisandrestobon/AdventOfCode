package year2022.day13.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistressSignalTest {
    private final DistressSignal distressSignal = new DistressSignal();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day13.txt");
        int expected = 140;
        int actual = distressSignal.getDecoderKey(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day13.txt");
        int expected = 22000;
        int actual = distressSignal.getDecoderKey(testList);
        assertEquals(expected, actual);
    }
}
