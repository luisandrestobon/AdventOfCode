package year2021.day11.part2;

import org.junit.jupiter.api.Test;

import static common.FileModule.file2IntegerMatrix;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DumboOctopusTest {
    private final DumboOctopus dumboOctopus = new DumboOctopus();

    @Test
    void firstTest() {
        int[][] testMatrix = file2IntegerMatrix("src/test/resources/year2021/test_day11.txt");
        int expected = 195;
        int actual = dumboOctopus.firstStepWhenAllFlash(testMatrix);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        int[][] testMatrix = file2IntegerMatrix("src/test/resources/year2021/input_day11.txt");
        int expected = 476;
        int actual = dumboOctopus.firstStepWhenAllFlash(testMatrix);
        assertEquals(expected, actual);
    }
}
