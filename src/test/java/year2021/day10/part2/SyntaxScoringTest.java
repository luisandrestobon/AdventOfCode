package year2021.day10.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SyntaxScoringTest {
    private final SyntaxScoring syntaxScoring = new SyntaxScoring();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_day10.txt");
        long expected = 288957L;
        long actual = syntaxScoring.getMiddleScore(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day10.txt");
        long expected = 3654963618L;
        long actual = syntaxScoring.getMiddleScore(testList);
        assertEquals(expected, actual);
    }
}
