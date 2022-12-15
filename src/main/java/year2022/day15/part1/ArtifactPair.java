package year2022.day15.part1;

import java.util.Arrays;

public class ArtifactPair {

    private static final String POSITION_SEPARATOR = ",";
    private final String sensorPosition;
    private final String beaconPosition;
    private final long taxicabDistance;

    public ArtifactPair(String sensorPosition, String beaconPosition) {
        this.sensorPosition = sensorPosition;
        this.beaconPosition = beaconPosition;
        this.taxicabDistance = this.calculateTaxicabDistance();
    }

    public String getSensorPosition() {
        return sensorPosition;
    }

    public long getTaxicabDistance() {
        return taxicabDistance;
    }

    private long calculateTaxicabDistance() {
        long[] sensorCoordinates = extractCoordinatesFromPosition(sensorPosition);
        long[] beaconCoordinates = extractCoordinatesFromPosition(beaconPosition);
        return Math.abs(sensorCoordinates[0] - beaconCoordinates[0]) + Math.abs(sensorCoordinates[1] - beaconCoordinates[1]);
    }

    private long[] extractCoordinatesFromPosition(String position) {
        return Arrays.stream(position.split(POSITION_SEPARATOR)).mapToLong(Long::parseLong).toArray();
    }

}
