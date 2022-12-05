package year2022.day05.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupplyStacksTest {
    private final SupplyStacks supplyStacks = new SupplyStacks();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day05.txt");
        String expected = "CMZ";
        String actual = supplyStacks.getTopStackCrate(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day05.txt");
        String expected = "VGBBJCRMN";
        String actual = supplyStacks.getTopStackCrate(testList);
        assertEquals(expected, actual);
    }
}
