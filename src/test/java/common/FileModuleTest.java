package common;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static common.FileModule.file2IntegerList;

public class FileModuleTest {

    @Test
    void file2IntegerList_success() {
        List<Integer> expected = Arrays.asList(3, 7, 2, 8);
        List<Integer> actual = file2IntegerList("src/test/resources/common/file2integerlist.txt");
        assertEquals(expected, actual);
    }

}
