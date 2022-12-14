package year2022.day14.part1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegolithReservoir {

    private static final String LINE_SEPARATOR = " -> ";
    private static final String POSITION_SEPARATOR = ",";
    private static final String SOURCE_POSITION = "500,0";

    private int maxHeight = Integer.MIN_VALUE;

    private final Map<String, PointTypes> cave = new HashMap<>();
    public int unitsOfSandRest(List<String> testList) {
        initializeCave(testList);
        int unitsOfSand = 0;
        boolean fallingForever = false;
        while(!fallingForever) {
            fallingForever = pourUnitOfSand();
            unitsOfSand++;
        }
        return unitsOfSand - 1;
    }

    private boolean pourUnitOfSand() {
        String position = SOURCE_POSITION;
        int[] coordinates = extractCoordinatesFromPosition(position);
        String nextStepPosition;
        int[] nextStepCoordinates = coordinates;
        while (coordinates[1] < maxHeight) {
            // Check one step down
            nextStepCoordinates[1] = nextStepCoordinates[1] + 1;
            nextStepPosition = extractPositionFromCoordinates(nextStepCoordinates);
            if (!cave.containsKey(nextStepPosition)) {
                // Go to that position
                coordinates = nextStepCoordinates;
                position = nextStepPosition;
                continue;
            }
            // Check one step down and to the left
            nextStepCoordinates[0] = nextStepCoordinates[0] - 1;
            nextStepPosition = extractPositionFromCoordinates(nextStepCoordinates);
            if (!cave.containsKey(nextStepPosition)) {
                // Go to that position
                coordinates = nextStepCoordinates;
                position = nextStepPosition;
                continue;
            }
            // Check one step down and to the right
            nextStepCoordinates[0] = nextStepCoordinates[0] + 2;
            nextStepPosition = extractPositionFromCoordinates(nextStepCoordinates);
            if (!cave.containsKey(nextStepPosition)) {
                // Go to that position
                coordinates = nextStepCoordinates;
                position = nextStepPosition;
                continue;
            }
            // I can't move, so stay there
            cave.put(position, PointTypes.SAND);
            return false;
        }
        return true;
    }

    private void initializeCave(List<String> testList) {
        cave.put(SOURCE_POSITION, PointTypes.SOURCE);
        int[] sourceCoordinates = extractCoordinatesFromPosition(SOURCE_POSITION);
        setMaxHeight(sourceCoordinates[1]);
        for (String line : testList) {
            String[] edges = line.split(LINE_SEPARATOR);
            for (int k = 1; k < edges.length; k++) {
                int[] start = extractCoordinatesFromPosition(edges[k - 1]);
                int[] end = extractCoordinatesFromPosition(edges[k]);
                if (start[0] == end[0]) {
                    // Vertical line
                    int startJ = Math.min(start[1], end[1]);
                    int endJ = Math.max(start[1], end[1]);
                    for (int j = startJ; j <= endJ; j++) {
                        cave.put("" + start[0] + POSITION_SEPARATOR + j, PointTypes.ROCK);
                        setMaxHeight(startJ);
                    }
                } else {
                    // Horizontal line
                    int startI = Math.min(start[0], end[0]);
                    int endI = Math.max(start[0], end[0]);
                    for (int i = startI; i <= endI; i++) {
                        cave.put("" + i + POSITION_SEPARATOR + start[1], PointTypes.ROCK);
                        setMaxHeight(start[1]);
                    }
                }
            }
        }
    }

    private int[] extractCoordinatesFromPosition(String position) {
        return Arrays.stream(position.split(POSITION_SEPARATOR)).mapToInt(Integer::parseInt).toArray();
    }

    private String extractPositionFromCoordinates(int... coordinates) {
        return "" + coordinates[0] + POSITION_SEPARATOR + coordinates[1];
    }

    private void setMaxHeight(int j) {
        maxHeight = Math.max(j, maxHeight);
    }
}
