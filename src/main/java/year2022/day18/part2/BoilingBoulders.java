package year2022.day18.part2;

import java.util.*;

public class BoilingBoulders {
    private static final String LINE_SEPARATOR = ",";
    private static final int CUBE_SIDES = 6;
    private int[][] cubes;

    private final List<int[][]> airCubes = new ArrayList<>();

    private final Set<String> cubePositions = new HashSet<>();
    private final List<Set<String>> airCubePositions = new ArrayList<>();

    private final Set<String> airCubeVisited = new HashSet<>();

    private final int[] minCoordinates = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
    private final int[] maxCoordinates = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

    private int[] sidesNotCovered;

    private final List<int[]> airSidesNotCovered = new ArrayList<>();

    private final int[][] deltas = new int[][] {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    private Deque<String> deque = new ArrayDeque<>();

    public int surfaceAreaLavaDroplet(List<String> testList) {
        initializeCubes(testList);
        calculateSidesNotCovered();
        initializeAirCubes();
        calculateAirSidesNotCovered();
        int numSidesNotCovered = Arrays.stream(sidesNotCovered).reduce(0, Integer::sum);
        int numAirSidesNotCovered = airSidesNotCovered.stream().map(arr -> Arrays.stream(arr).reduce(0, Integer::sum)).reduce(0, Integer::sum);
        return numSidesNotCovered - numAirSidesNotCovered;
    }

    private void calculateSidesNotCovered() {
        for (int i = 0; i < cubes.length; i++) {
            for (int j = i + 1; j < cubes.length; j++) {
                if (
                        ((cubes[i][0] == cubes[j][0]) && (cubes[i][1] == cubes[j][1]) && (Math.abs(cubes[i][2] - cubes[j][2]) == 1)) ||
                                ((cubes[i][0] == cubes[j][0]) && (cubes[i][2] == cubes[j][2]) && (Math.abs(cubes[i][1] - cubes[j][1]) == 1)) ||
                                ((cubes[i][1] == cubes[j][1]) && (cubes[i][2] == cubes[j][2]) && (Math.abs(cubes[i][0] - cubes[j][0]) == 1))
                ) {
                    sidesNotCovered[i]--;
                    sidesNotCovered[j]--;
                }
            }
        }
    }

    private void calculateAirSidesNotCovered() {
        int k = 0;
        for (int[][] airCubesPart : airCubes) {
            for (int i = 0; i < airCubesPart.length; i++) {
                for (int j = i + 1; j < airCubesPart.length; j++) {
                    if (
                            ((airCubesPart[i][0] == airCubesPart[j][0]) && (airCubesPart[i][1] == airCubesPart[j][1]) && (Math.abs(airCubesPart[i][2] - airCubesPart[j][2]) == 1)) ||
                                    ((airCubesPart[i][0] == airCubesPart[j][0]) && (airCubesPart[i][2] == airCubesPart[j][2]) && (Math.abs(airCubesPart[i][1] - airCubesPart[j][1]) == 1)) ||
                                    ((airCubesPart[i][1] == airCubesPart[j][1]) && (airCubesPart[i][2] == airCubesPart[j][2]) && (Math.abs(airCubesPart[i][0] - airCubesPart[j][0]) == 1))
                    ) {
                        airSidesNotCovered.get(k)[i]--;
                        airSidesNotCovered.get(k)[j]--;
                    }
                }
            }
            k++;
        }
    }

    private void initializeCubes(List<String> testList) {
        sidesNotCovered = new int[testList.size()];
        Arrays.fill(sidesNotCovered, CUBE_SIDES);
        cubes = new int[testList.size()][3];
        for (int i = 0; i < testList.size(); i++) {
            String line = testList.get(i);
            cubePositions.add(line);
            cubes[i] = Arrays.stream(line.split(LINE_SEPARATOR)).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 3; j++) {
                minCoordinates[j] = Math.min(minCoordinates[j], cubes[i][j]);
                maxCoordinates[j] = Math.max(maxCoordinates[j], cubes[i][j]);
            }
        }
    }

    private void initializeAirCubes() {
        for (int x = minCoordinates[0] + 1; x < maxCoordinates[0]; x++) {
            for (int y = minCoordinates[1] + 1; y < maxCoordinates[1]; y++) {
                for (int z = minCoordinates[2] + 1; z < maxCoordinates[2]; z++) {
                    String position = extractPositionFromCoordinates(x, y, z);
                    if (!cubePositions.contains(position) && !airCubeVisited.contains(position)) {
                        Set<String> airPocketPositions = new HashSet<>();
                        deque = new ArrayDeque<>();
                        boolean isAirPocket = getAirPocket(position, airPocketPositions);
                        if (isAirPocket) {
                            airCubePositions.add(airPocketPositions);
                        }
                    }
                }
            }
        }
        for (Set<String> airCubePositionsPart : airCubePositions) {
            int [][] airCubesPart = new int[airCubePositionsPart.size()][3];
            int i = 0;
            for (String position : airCubePositionsPart) {
                airCubesPart[i] = Arrays.stream(position.split(LINE_SEPARATOR)).mapToInt(Integer::parseInt).toArray();
                i++;
            }
            int[] airSidesNotCoveredPart = new int[airCubePositionsPart.size()];
            Arrays.fill(airSidesNotCoveredPart, CUBE_SIDES);
            airSidesNotCovered.add(airSidesNotCoveredPart);
            airCubes.add(airCubesPart);
        }
    }

    private boolean getAirPocket(String initialPosition, Set<String> airPockets) {
        boolean isAirPocket = true;
        deque.offer(initialPosition);
        while (!deque.isEmpty()) {
            String position = deque.poll();
            airCubeVisited.add(position);
            int[] coordinates = extractCoordinatesFromPosition(position);
            for (int[] delta : deltas) {
                String newPosition = extractPositionFromCoordinates(coordinates[0] + delta[0], coordinates[1] + delta[1], coordinates[2] + delta[2]);
                if (isOutsideRange(newPosition)) {
                    isAirPocket = false;
                } else if (!cubePositions.contains(newPosition) && !deque.contains(newPosition) && !airPockets.contains(newPosition)) {
                    deque.offer(newPosition);
                }
            }
            airPockets.add(position);
        }
        return isAirPocket;
    }

    private boolean isOutsideRange(String position) {
        int[] coordinates = extractCoordinatesFromPosition(position);
        return coordinates[0] < minCoordinates[0] || coordinates[0] > maxCoordinates[0] ||
                coordinates[1] < minCoordinates[1] || coordinates[1] > maxCoordinates[1] ||
                coordinates[2] < minCoordinates[2] || coordinates[2] > maxCoordinates[2];
    }

    private String extractPositionFromCoordinates(int... coordinates) {
        StringBuilder sb = new StringBuilder();
        for (int coordinate : coordinates) {
            sb.append(coordinate);
            sb.append(LINE_SEPARATOR);
        }
        return sb.substring(0, sb.length() - 1);
    }

    private int[] extractCoordinatesFromPosition(String position) {
        return Arrays.stream(position.split(LINE_SEPARATOR)).mapToInt(Integer::parseInt).toArray();
    }
}
