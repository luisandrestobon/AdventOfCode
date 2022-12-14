package year2021.day13.part1;

import org.junit.jupiter.api.Test;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class TransparentOrigamiTest {
    private final TransparentOrigami transparentOrigami = new TransparentOrigami();

    @Test
    void firstTest(){
        List<String> testList = file2StringList("src/test/resources/year2021/test_day13.txt");
        int expected = 17;
        int actual = transparentOrigami.visibleDots(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2021/input_day13.txt");
        int expected = 818;
        int actual = transparentOrigami.visibleDots(testList);
        assertEquals(expected, actual);
    }
}
