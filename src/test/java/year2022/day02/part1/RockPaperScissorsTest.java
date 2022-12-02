package year2022.day02.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static common.FileModule.file2StringList;


public class RockPaperScissorsTest {
    private final RockPaperScissors rockPaperScissors = new RockPaperScissors();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day02.txt");
        int expected = 15;
        int actual = rockPaperScissors.getTotalScore(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day02.txt");
        int expected = 12458;
        int actual = rockPaperScissors.getTotalScore(testList);
        assertEquals(expected, actual);
    }
}
