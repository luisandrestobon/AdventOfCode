package year2022.day02.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RockPaperScissorsTest {
    private final RockPaperScissors rockPaperScissors = new RockPaperScissors();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day02.txt");
        int expected = 12;
        int actual = rockPaperScissors.getRealTotalScore(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day02.txt");
        int expected = 12683;
        int actual = rockPaperScissors.getRealTotalScore(testList);
        assertEquals(expected, actual);
    }
}
