package year2022.day17.part1;

import java.util.*;

public class PyroclasticFlow {
    private static final int WIDTH = 7;
    private static final int INITIAL_LEFT_GAP = 2;
    private static final int INITIAL_BOTTOM_GAP = 3;
    private static final int MAX_ROCK_NUMBER = 2022;
    //private static final int MAX_ROCK_NUMBER = 10;
    private static final String POSITION_SEPARATOR = ",";

    private int heightHighestRock = -1;
    private final Set<String> chamber = new HashSet<>();
    private final Map<Integer, int[][]> rocks = new HashMap<>() {{
        put(0, new int[][] {{0, 0}, {0, 1}, {0, 2}, {0,3}});
        put(1, new int[][] {{0, 1}, {-1, 0}, {-1, 1}, {-1, 2}, {-2, 1}});
        put(2, new int[][] {{0, 2}, {-1, 2}, {-2, 0}, {-2, 1}, {-2, 2}});
        put(3, new int[][] {{0, 0}, {-1, 0}, {-2, 0}, {-3, 0}});
        put(4, new int[][] {{0, 0}, {0, 1}, {-1, 0}, {-1, 1}});
    }};

    private final Map<Integer, Integer> rockHeights = new HashMap<>() {{
        put(0, 1);
        put(1, 3);
        put(2, 3);
        put(3, 4);
        put(4, 2);
    }};
    private final Map<Character, Integer> movements = new HashMap<>() {{
        put('>', 1);
        put('<', -1);
    }};

    private int[] rockPosition = {INITIAL_BOTTOM_GAP, INITIAL_LEFT_GAP};

    public int towerUnitsTall(String testList) {
        int rockNumber = 0;
        int commandIndex = 0;
        int rockIndex = 0;
        int[][] rock;
        while (rockNumber < MAX_ROCK_NUMBER) {
            //showChamber();
            rock = rocks.get(rockIndex);
            int movement = movements.get(testList.charAt(commandIndex));
            pushRock(rock, movement);
            boolean isFalling = fallingRock(rock);
            if (!isFalling) {
                rockIndex = rockIndex + 1 >= rocks.size() ? 0 : rockIndex + 1;
                heightHighestRock = Math.max(rockPosition[0], heightHighestRock);
                rockPosition[0] = INITIAL_BOTTOM_GAP + heightHighestRock + rockHeights.get(rockIndex);
                rockPosition[1] = INITIAL_LEFT_GAP;
                rockNumber++;
                //showChamber();
            }
            commandIndex = commandIndex + 1 >= testList.length() ? 0 : commandIndex + 1;
        }
        return heightHighestRock + 1;
    }

    private boolean fallingRock(int[][] rock) {
        int[] newRockPosition = rockPosition.clone();
        newRockPosition[0] -= 1;
        for (int[] delta : rock) {
            String position = extractPositionFromCoordinates(newRockPosition[0] + delta[0], newRockPosition[1] + delta[1]);
            if (delta[0] + newRockPosition[0] < 0 || chamber.contains(position)) {
                addToChamber(rock);
                return false;
            }
        }
        rockPosition = newRockPosition;
        return true;
    }

    private void addToChamber(int[][] rock) {
        for (int[] delta : rock) {
            String position = extractPositionFromCoordinates(delta[0] + rockPosition[0], delta[1] + rockPosition[1]);
            chamber.add(position);
        }
    }

    private void pushRock(int[][] rock, int movement) {
        int[] newRockPosition = rockPosition.clone();
        newRockPosition[1] += movement;
        for (int[] delta : rock) {
            if (delta[1] + newRockPosition[1] < 0 || delta[1] + newRockPosition[1] >= WIDTH) {
                return;
            }
            String position = extractPositionFromCoordinates(newRockPosition[0] + delta[0], newRockPosition[1] + delta[1]);
            if (chamber.contains(position)) {
                return;
            }
        }
        rockPosition = newRockPosition;
    }

    private String extractPositionFromCoordinates(int... coordinates) {
        return "" + coordinates[0] + POSITION_SEPARATOR + coordinates[1];
    }

    /*private long[] extractCoordinatesFromPosition(String position) {
        return Arrays.stream(position.split(POSITION_SEPARATOR)).mapToLong(Long::parseLong).toArray();
    }*/

    /*private void showChamber() {
        System.out.println("*******************************************");
        System.out.println();
        int[][] rock = rocks.get(rockIndex);
        for (int i = rockPosition[0]; i >= -1; i--) {
            for (int j = -1; j <= WIDTH; j++) {
                if (j == -1 || j == WIDTH) {
                    if (i == -1) {
                        System.out.print("+");
                    } else {
                        System.out.print("|");
                    }
                } else {
                    if (i == -1) {
                        System.out.print("-");
                    } else {
                        boolean isFallingRock = false;
                        for (int[] part : rock) {
                            int iPart = rockPosition[0] + part[0];
                            int jPart = rockPosition[1] + part[1];
                            if (i == iPart && j == jPart) {
                                isFallingRock = true;
                                break;
                            }
                        }
                        if (isFallingRock) {
                            System.out.print("@");
                        } else {
                            String position = extractPositionFromCoordinates(i, j);
                            if (chamber.contains(position)) {
                                System.out.print("#");
                            } else {
                                System.out.print(".");
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }*/
}
