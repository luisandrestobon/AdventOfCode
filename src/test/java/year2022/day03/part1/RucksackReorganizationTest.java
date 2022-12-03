package year2022.day03.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RucksackReorganizationTest {
    private final RucksackReorganization rucksackReorganization = new RucksackReorganization();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day03.txt");
        int expected = 157;
        int actual = rucksackReorganization.sumPrioritiesItemTypes(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day03.txt");
        int expected = 7917;
        int actual = rucksackReorganization.sumPrioritiesItemTypes(testList);
        assertEquals(expected, actual);
    }
}
