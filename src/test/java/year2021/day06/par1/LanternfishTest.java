package year2021.day06.par1;

import org.junit.jupiter.api.Test;
import year2021.day06.part1.Lanternfish;

import static common.FileModule.file2String;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanternfishTest {

    private Lanternfish lanternfish = new Lanternfish();

    @Test
    void firstTest() {
        String testStr = file2String("src/test/resources/year2021/test_day06.txt");
        long expected = 5934L;
        long actual = lanternfish.pointsOverlaping(testStr);
        assertEquals(expected, actual);
    }
}
