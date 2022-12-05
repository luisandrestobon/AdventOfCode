package year2022.day05.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupplyStacksTest {
    private final SupplyStacks supplyStacks = new SupplyStacks();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day05.txt");
        String expected = "MCD";
        String actual = supplyStacks.getTopStackCrate9001(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day05.txt");
        String expected = "LBBVJBRMH";
        String actual = supplyStacks.getTopStackCrate9001(testList);
        assertEquals(expected, actual);
    }
}
