package year2021.day07.part2;

import org.junit.jupiter.api.Test;

import static common.FileModule.file2String;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheTreacheryOfWhalesTest {
    private final TheTreacheryOfWhales theTreacheryOfWhales = new TheTreacheryOfWhales();

    @Test
    void firstTest() {
        String testStr = file2String("src/test/resources/year2021/test_day07.txt");
        int expected = 168;
        int actual = theTreacheryOfWhales.fuelSpendProgression(testStr);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        String testStr = file2String("src/test/resources/year2021/input_day07.txt");
        int expected = 95476244;
        int actual = theTreacheryOfWhales.fuelSpendProgression(testStr);
        assertEquals(expected, actual);
    }
}
