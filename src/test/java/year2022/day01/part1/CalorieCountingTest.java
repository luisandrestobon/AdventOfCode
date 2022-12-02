package year2022.day01.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static common.FileModule.file2StringList;

public class CalorieCountingTest {
    private final CalorieCounting calorieCounting = new CalorieCounting();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day01.txt");
        int expected = 24000;
        int actual = calorieCounting.totalCaloriesElfCarrying(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day01.txt");
        int expected = 71780;
        int actual = calorieCounting.totalCaloriesElfCarrying(testList);
        assertEquals(expected, actual);
    }
}
