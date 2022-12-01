package year2022.day01.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalorieCountingTest {
    private final CalorieCounting calorieCounting = new CalorieCounting();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day01.txt");
        int expected = 45000;
        int actual = calorieCounting.totalCaloriesTopThreeElfCarrying(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day01.txt");
        int expected = 212489;
        int actual = calorieCounting.totalCaloriesTopThreeElfCarrying(testList);
        assertEquals(expected, actual);
    }
}
