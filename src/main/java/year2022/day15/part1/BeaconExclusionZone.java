package year2022.day15.part1;

import java.util.*;

public class BeaconExclusionZone {

    private static final String POSITION_SEPARATOR = ",";
    private static final String INSTRUCTION_SEPARATOR = ":";
    private static final String WORD_SEPARATOR = " ";
    private static final String AXIS_SEPARATOR = "=";
    private final Set<ArtifactPair> tunnels = new HashSet<>();
    private final Set<String> artifactPositions = new HashSet<>();
    public long positionsCannotContainBeacon(List<String> testList, long evaluatedRow) {
        initializeTunnels(testList);
        return evaluateRow(evaluatedRow);
    }

    private long evaluateRow(long evaluatedRow) {
        Set<Long> rowPositions = new HashSet<>();
        for (ArtifactPair artifact : tunnels) {
            long[] sensorCoordinates = extractCoordinatesFromPosition(artifact.getSensorPosition());
            long taxicabDistance = artifact.getTaxicabDistance();
            long distance = Math.abs(sensorCoordinates[1] - evaluatedRow);
            if (distance <= taxicabDistance) {
                long distanceLeft = taxicabDistance - distance;
                for (long i = 0L; i <= distanceLeft; i++) {
                    String evaluatedPosition = extractPositionFromCoordinates(sensorCoordinates[0] + i, evaluatedRow);
                    if (!artifactPositions.contains(evaluatedPosition)) {
                        rowPositions.add(sensorCoordinates[0] + i);
                    }
                    evaluatedPosition = extractPositionFromCoordinates(sensorCoordinates[0] - i, evaluatedRow);
                    if (!artifactPositions.contains(evaluatedPosition)) {
                        rowPositions.add(sensorCoordinates[0] - i);
                    }
                }
            }
        }
        return rowPositions.size();
    }

    private void initializeTunnels(List<String> testList) {
        for (String line : testList) {
            String[] instructions = line.split(INSTRUCTION_SEPARATOR);
            String sensorPosition = extractSensorPosition(instructions[0]);
            artifactPositions.add(sensorPosition);
            String beaconPosition = extractBeaconPosition(instructions[1]);
            artifactPositions.add(beaconPosition);
            tunnels.add(new ArtifactPair(sensorPosition, beaconPosition));
        }
    }

    private String extractSensorPosition(String sensorInstructions) {
        String[] words = sensorInstructions.split(WORD_SEPARATOR);
        long x = Long.parseLong(words[2].replace(",", "").split(AXIS_SEPARATOR)[1]);
        long y = Long.parseLong(words[3].split(AXIS_SEPARATOR)[1]);
        return extractPositionFromCoordinates(x, y);
    }

    private String extractBeaconPosition(String beaconInstruction) {
        String[] words = beaconInstruction.trim().split(WORD_SEPARATOR);
        long x = Long.parseLong(words[4].replace(",", "").split(AXIS_SEPARATOR)[1]);
        long y = Long.parseLong(words[5].split(AXIS_SEPARATOR)[1]);
        return extractPositionFromCoordinates(x, y);
    }

    private long[] extractCoordinatesFromPosition(String position) {
        return Arrays.stream(position.split(POSITION_SEPARATOR)).mapToLong(Long::parseLong).toArray();
    }

    private String extractPositionFromCoordinates(long... coordinates) {
        return "" + coordinates[0] + POSITION_SEPARATOR + coordinates[1];
    }
}
