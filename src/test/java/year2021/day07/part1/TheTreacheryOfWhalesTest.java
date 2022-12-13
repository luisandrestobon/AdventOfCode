package year2021.day07.part1;

import org.junit.jupiter.api.Test;

import static common.FileModule.file2String;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheTreacheryOfWhalesTest {
    private final TheTreacheryOfWhales theTreacheryOfWhales = new TheTreacheryOfWhales();

    @Test
    void firstTest() {
        String testStr = file2String("src/test/resources/year2021/test_day07.txt");
        int expected = 37;
        int actual = theTreacheryOfWhales.fuelSpend(testStr);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        String testStr = file2String("src/test/resources/year2021/input_day07.txt");
        int expected = 339321;
        int actual = theTreacheryOfWhales.fuelSpend(testStr);
        assertEquals(expected, actual);
    }
}
