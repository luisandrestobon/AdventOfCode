package year2022.day15.part2;

import java.util.*;

public class BeaconExclusionZone {

    private static final long FACTOR = 4000000;
    private static final String POSITION_SEPARATOR = ",";
    private static final String INSTRUCTION_SEPARATOR = ":";
    private static final String WORD_SEPARATOR = " ";
    private static final String AXIS_SEPARATOR = "=";
    private final Set<ArtifactPair> tunnels = new HashSet<>();
    private List<long[]> columnPositions = new ArrayList<>();

    public long tuningFrequency(List<String> testList, long maxDistance) {
        initializeTunnels(testList);
        long[] allColumns = {0L, maxDistance};
        long row = 0L;
        for (long i = 0; i <= maxDistance; i++) {
            boolean isAllColumns = false;
            columnPositions = evaluateRow(i, maxDistance);
            for (long[] columnPosition : columnPositions) {
                if (Arrays.equals(columnPosition, allColumns)) {
                    isAllColumns = true;
                    break;
                }
            }
            if (!isAllColumns) {
                row = i;
                break;
            }
        }
        long column;
        long[] segment = columnPositions.get(0);
        if (columnPositions.size() == 1) {
            if (segment[0] == 1L) {
                column = 0L;
            } else {
                column = maxDistance;
            }
        } else {
            column = segment[1] + 1;
        }
        return FACTOR * column + row;
    }

    private List<long[]> evaluateRow(long evaluatedRow, long maxDistance) {
        List<long[]> columnPositions = new ArrayList<>();
        for (ArtifactPair artifact : tunnels) {
            long[] sensorCoordinates = extractCoordinatesFromPosition(artifact.getSensorPosition());
            long taxicabDistance = artifact.getTaxicabDistance();
            long distance = Math.abs(sensorCoordinates[1] - evaluatedRow);
            if (distance <= taxicabDistance) {
                long distanceLeft = taxicabDistance - distance;
                long start = Math.max(sensorCoordinates[0] - distanceLeft, 0L);
                long end = Math.min(sensorCoordinates[0] + distanceLeft, maxDistance);
                boolean added;
                List<long[]> newColumnPositions = new ArrayList<>();
                for (long[] columnPosition : columnPositions) {
                    added = false;
                    if (start <= columnPosition[0] && end >= columnPosition[1]) {
                        // New one contains previous one
                        added = true;
                    } else if (start <= columnPosition[0] && end >= columnPosition[0] && end <= columnPosition[1]) {
                        // Lower start of the new one
                        end = columnPosition[1];
                        added = true;
                    } else if (start >= columnPosition[0] && start <= columnPosition[1] && end >= columnPosition[1]) {
                        // Greater end of the new one
                        start = columnPosition[0];
                        added = true;
                    } else if (start >= columnPosition[0] && end <= columnPosition[1]) {
                        // Previous one contains new one
                        start = columnPosition[0];
                        end = columnPosition[1];
                        added = true;
                    }
                    if (!added) {
                        newColumnPositions.add(columnPosition);
                    }
                }
                long[] segment = {start, end};
                newColumnPositions.add(segment);
                newColumnPositions.sort(Comparator.comparingLong(o -> o[0]));
                columnPositions = newColumnPositions;
            }
        }
        return columnPositions;
    }

    private void initializeTunnels(List<String> testList) {
        for (String line : testList) {
            String[] instructions = line.split(INSTRUCTION_SEPARATOR);
            String sensorPosition = extractSensorPosition(instructions[0]);
            String beaconPosition = extractBeaconPosition(instructions[1]);
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
