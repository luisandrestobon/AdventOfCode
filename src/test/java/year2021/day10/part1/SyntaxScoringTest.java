package year2021.day10.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SyntaxScoringTest {
    private final SyntaxScoring syntaxScoring = new SyntaxScoring();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/test_day10.txt");
        int expected = 26397;
        int actual = syntaxScoring.getTotalSyntaxErrorScore(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day10.txt");
        int expected = 299793;
        int actual = syntaxScoring.getTotalSyntaxErrorScore(testList);
        assertEquals(expected, actual);
    }
}
