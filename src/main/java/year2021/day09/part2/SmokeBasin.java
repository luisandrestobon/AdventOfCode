package year2021.day09.part2;

import java.util.*;

public class SmokeBasin {

    private int[][] matrix;
    private final Map<String, Basin> lowPoints = new HashMap<>();
    private final int[][] positions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private final Set<String> seen = new HashSet<>();
    private final Deque<String> queue = new ArrayDeque<>();

    public int obtainBasinSizesGraph(List<String> testList) {
        populateMatrix(testList);
        sumRiskLevels(testList);
        for (Map.Entry<String, Basin> entry : lowPoints.entrySet()) {
            String point = entry.getKey();
            Set<String> outputSet = getGraphSize(point);
            Basin basin = lowPoints.get(point);
            basin.setSeen(outputSet);
            lowPoints.put(point, basin);
        }
        return lowPoints.values().stream().map(Basin::getSize).sorted(Comparator.reverseOrder()).limit(3).reduce(1, (subTotal, element) -> subTotal * element);
    }

    private void sumRiskLevels(List<String> testList) {
        populateMatrix(testList);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                calculateRisk(i, j);
            }
        }
    }

    private Set<String> getGraphSize(String point) {
        queue.clear();
        // First position
        Set<String> outputSet = new HashSet<>();
        queue.offer(point);
        seen.add(point);
        outputSet.add(point);
        while (!queue.isEmpty()) {
            // Pick the first item of the queue
            String current = queue.poll();
            // Put the right neighbours in the queue
            addRightNeighboursToQueue(current, outputSet);
        }
        return outputSet;
    }

    private void addRightNeighboursToQueue(String current, Set<String> outputSet) {
        int[] coordinates = obtainCoordinates(current);
        int i0 = coordinates[0];
        int j0 = coordinates[1];
        int[][] rightPositions = Arrays.stream(positions).filter(p -> insideBoundaries(i0 + p[0], j0 + p[1])).toArray(int[][]::new);
        Arrays.stream(rightPositions).forEach(p -> {
            if (isValid(i0, p[0], j0, p[1])) {
                String strPoint = obtainStrPoint(i0 + p[0], j0 + p[1]);
                queue.offer(strPoint);
                seen.add(strPoint);
                outputSet.add(strPoint);
            }
        });
    }

    private String obtainStrPoint(int i, int j) {
        return i + "," + j;
    }

    private int[] obtainCoordinates(String point) {
        return Arrays.stream(point.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    private boolean isValid(int i0, int i1, int j0, int j1) {
        return matrix[i0 + i1][j0 + j1] != 9 && !seen.contains(obtainStrPoint(i0 + i1, j0 + j1)) && matrix[i0][j0] <= matrix[i0 + i1][j0 + j1];
    }

    private void populateMatrix(List<String> testList) {
        matrix = new int[testList.size()][testList.get(0).length()];
        for (int i = 0; i < testList.size(); i++) {
            int[] row = Arrays.stream(testList.get(i).split("")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }
    }

    private void calculateRisk(int i, int j) {
        boolean isLowPoint = Arrays.stream(positions).filter(p -> insideBoundaries(i + p[0], j + p[1])).allMatch(p -> matrix[i][j] < matrix[i + p[0]][j + p[1]]);
        if (isLowPoint) {
            lowPoints.put(i + "," + j, new Basin(matrix[i][j]));
        }
    }

    private boolean insideBoundaries(int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
}
