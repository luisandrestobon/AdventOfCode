package year2022.day17.part1;

import org.junit.jupiter.api.Test;

import static common.FileModule.file2String;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyroclasticFlowTest {
    private final PyroclasticFlow pyroclasticFlow = new PyroclasticFlow();

    @Test
    void firstTest() {
        String testList = file2String("src/test/resources/year2022/test_day17.txt");
        int expected = 3068;
        int actual = pyroclasticFlow.towerUnitsTall(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        String testList = file2String("src/test/resources/year2022/input_day17.txt");
        int expected = 3177;
        int actual = pyroclasticFlow.towerUnitsTall(testList);
        assertEquals(expected, actual);
    }
}
