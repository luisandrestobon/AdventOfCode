package year2021.day11.part1;

import org.junit.jupiter.api.Test;

import static common.FileModule.file2IntegerMatrix;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DumboOctopusTest {
    private final DumboOctopus dumboOctopus = new DumboOctopus();

    @Test
    void firstTest() {
        int[][] testMatrix = file2IntegerMatrix("src/test/resources/year2021/test_day11.txt");
        int expected = 1656;
        int actual = dumboOctopus.getTotalFlashes(testMatrix);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        int[][] testMatrix = file2IntegerMatrix("src/test/resources/year2021/input_day11.txt");
        int expected = 1717;
        int actual = dumboOctopus.getTotalFlashes(testMatrix);
        assertEquals(expected, actual);
    }
}
