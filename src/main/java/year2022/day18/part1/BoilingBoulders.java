package year2022.day18.part1;

import java.util.Arrays;
import java.util.List;

public class BoilingBoulders {
    private static final String LINE_SEPARATOR = ",";
    private static final int CUBE_SIDES = 6;
    private int[][] cubes;

    private int[] sidesNotCovered;
    public int surfaceAreaLavaDroplet(List<String> testList) {
        initializeCubes(testList);
        calculateSidesNotCovered();
        //return (cubes.length * CUBE_SIDES) - 2 * sidesCovered;
        return Arrays.stream(sidesNotCovered).reduce(0, Integer::sum);
    }

    private void calculateSidesNotCovered() {
        for (int i = 0; i < cubes.length; i++) {
            for (int j = i + 1; j < cubes.length; j++) {
                //System.out.println("---------------------------------------");
                //System.out.println(Arrays.toString(cubes[i]));
                //System.out.println(Arrays.toString(cubes[j]));
                if (
                        ((cubes[i][0] == cubes[j][0]) && (cubes[i][1] == cubes[j][1]) && (Math.abs(cubes[i][2] - cubes[j][2]) == 1)) ||
                                ((cubes[i][0] == cubes[j][0]) && (cubes[i][2] == cubes[j][2]) && (Math.abs(cubes[i][1] - cubes[j][1]) == 1)) ||
                                ((cubes[i][1] == cubes[j][1]) && (cubes[i][2] == cubes[j][2]) && (Math.abs(cubes[i][0] - cubes[j][0]) == 1))
                ) {
                    //System.out.println("Side covered...");
                    sidesNotCovered[i]--;
                    sidesNotCovered[j]--;
                }
            }
        }
    }

    private void initializeCubes(List<String> testList) {
        sidesNotCovered = new int[testList.size()];
        Arrays.fill(sidesNotCovered, CUBE_SIDES);
        cubes = new int[testList.size()][3];
        for (int i = 0; i < testList.size(); i++) {
            cubes[i] = Arrays.stream(testList.get(i).split(LINE_SEPARATOR)).mapToInt(Integer::parseInt).toArray();
        }
    }
}
