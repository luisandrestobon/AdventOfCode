package year2022.day15.part1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeaconExclusionZoneTest {
    private final BeaconExclusionZone beaconExclusionZone = new BeaconExclusionZone();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day15.txt");
        long evaluatedRow = 10L;
        long expected = 26L;
        long actual = beaconExclusionZone.positionsCannotContainBeacon(testList, evaluatedRow);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day15.txt");
        long evaluatedRow = 2000000L;
        long expected = 5688618L;
        long actual = beaconExclusionZone.positionsCannotContainBeacon(testList, evaluatedRow);
        assertEquals(expected, actual);
    }
}
