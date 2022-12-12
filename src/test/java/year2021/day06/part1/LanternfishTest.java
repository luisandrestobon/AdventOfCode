package year2021.day06.part1;

import org.junit.jupiter.api.Test;

import static common.FileModule.file2String;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanternfishTest {
    private final Lanternfish lanternfish = new Lanternfish();

    @Test
    void firstTest() {
        String testStr = file2String("src/test/resources/year2021/test_day06.txt");
        long expected = 5934L;
        long actual = lanternfish.pointsOverlaping(testStr);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        String testStr = file2String("src/test/resources/year2021/input_day06.txt");
        long expected = 379414L;
        long actual = lanternfish.pointsOverlaping(testStr);
        assertEquals(expected, actual);
    }
}
