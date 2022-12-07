package year2022.day07.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoSpaceLeftOnDeviceTest {
    private final NoSpaceLeftOnDevice noSpaceLeftOnDevice2 = new NoSpaceLeftOnDevice();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day07.txt");
        long expected = 24933642L;
        long actual = noSpaceLeftOnDevice2.sizeDirectoryToDelete(testList);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day07.txt");
        long expected = 10475598L;
        long actual = noSpaceLeftOnDevice2.sizeDirectoryToDelete(testList);
        assertEquals(expected, actual);
    }
}
