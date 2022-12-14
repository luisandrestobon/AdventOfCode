package year2022.day14.part2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegolithReservoir {

    private static final String LINE_SEPARATOR = " -> ";
    private static final String POSITION_SEPARATOR = ",";
    private static final String SOURCE_POSITION = "500,0";
    private static final int FLOOR_GAP = 2;

    private int maxHeight = Integer.MIN_VALUE;

    private final Map<String, PointTypes> cave = new HashMap<>();
    public int unitsOfSandRestWithFloor(List<String> testList) {
        initializeCave(testList);
        int unitsOfSand = 0;
        boolean stopped = false;
        while(!stopped) {
            stopped = pourUnitOfSand();
            unitsOfSand++;
        }
        return unitsOfSand;
    }

    private boolean pourUnitOfSand() {
        String position = SOURCE_POSITION;
        String nextStepPosition;
        int[] nextStepCoordinates = extractCoordinatesFromPosition(position);
        while (true) {
            // Check one step down
            nextStepCoordinates[1] = nextStepCoordinates[1] + 1;
            nextStepPosition = extractPositionFromCoordinates(nextStepCoordinates);
            if (!cave.containsKey(nextStepPosition) && nextStepCoordinates[1] < maxHeight) {
                // Go to that position
                position = nextStepPosition;
                continue;
            }
            // Check one step down and to the left
            nextStepCoordinates[0] = nextStepCoordinates[0] - 1;
            nextStepPosition = extractPositionFromCoordinates(nextStepCoordinates);
            if (!cave.containsKey(nextStepPosition) && nextStepCoordinates[1] < maxHeight) {
                // Go to that position
                position = nextStepPosition;
                continue;
            }
            // Check one step down and to the right
            nextStepCoordinates[0] = nextStepCoordinates[0] + 2;
            nextStepPosition = extractPositionFromCoordinates(nextStepCoordinates);
            if (!cave.containsKey(nextStepPosition) && nextStepCoordinates[1] < maxHeight) {
                // Go to that position
                position = nextStepPosition;
                continue;
            }
            break;
            // I can't move, so stay there
        }
        if (position.equals(SOURCE_POSITION)) {
            return true;
        }
        cave.put(position, PointTypes.SAND);
        return false;
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
        maxHeight+= FLOOR_GAP;
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
