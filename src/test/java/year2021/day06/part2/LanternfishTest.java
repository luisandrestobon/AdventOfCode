package year2021.day06.part2;

import org.junit.jupiter.api.Test;

import static common.FileModule.file2String;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanternfishTest {
    private final Lanternfish lanternfish = new Lanternfish();

    @Test
    void firstTest() {
        String testStr = file2String("src/test/resources/year2021/test_day06.txt");
        long expected = 26984457539L;
        long actual = lanternfish.pointsOverlapingLongTime(testStr);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        String testStr = file2String("src/test/resources/year2021/input_day06.txt");
        long expected = 1705008653296L;
        long actual = lanternfish.pointsOverlapingLongTime(testStr);
        assertEquals(expected, actual);
    }
}
