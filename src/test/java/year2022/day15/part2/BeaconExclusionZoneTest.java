package year2022.day15.part2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.FileModule.file2StringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeaconExclusionZoneTest {
    private final BeaconExclusionZone beaconExclusionZone = new BeaconExclusionZone();

    @Test
    void firstTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/test_day15.txt");
        long maxDistance = 20L;
        long expected = 56000011L;
        long actual = beaconExclusionZone.tuningFrequency(testList, maxDistance);
        assertEquals(expected, actual);
    }

    @Test
    void inputTest() {
        List<String> testList = file2StringList("src/test/resources/year2022/input_day15.txt");
        long maxDistance = 4000000L;
        long expected = 12625383204261L;
        long actual = beaconExclusionZone.tuningFrequency(testList, maxDistance);
        assertEquals(expected, actual);
    }
}
