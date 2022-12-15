package year2021.day13.part1;

import java.util.*;

public class TransparentOrigami {

    private Set<String> transparentPaper = new HashSet<>();
    private final List<String> folds = new ArrayList<>();

    public int visibleDots(List<String> testList) {
        initializeTransparentPaperAndFolds(testList);
        for (String fold : folds) {
            foldTransparentPaper(fold);
            break;
        }
        return transparentPaper.size();
    }

    private void foldTransparentPaper(String fold) {
        String[] foldInstructions = fold.split("=");
        int offset = Integer.parseInt(foldInstructions[1]);
        Set<String> newTransparentPaper = new HashSet<>();
        for (String position : transparentPaper) {
            int[] coordinates = extractCoordinatesFromPosition(position);
            int axis = foldInstructions[0].equals("x") ? 0 : 1;
            if (coordinates[axis] > offset) {
                // Dot in opposite side
                coordinates[axis] -= 2 * (coordinates[axis] - offset);
            }
            newTransparentPaper.add(extractPositionFromCoordinates(coordinates));
        }
        transparentPaper = newTransparentPaper;
    }

    private void initializeTransparentPaperAndFolds(List<String> testList) {
        boolean isFold = false;
        for (String line : testList) {
            if (!isFold) {
                if (!line.isEmpty()) {
                    // Is a point
                    transparentPaper.add(line);
                } else {
                    // Change to folds
                    isFold = true;
                }
            } else {
                // Is a fold
                folds.add(line.split(" ")[2]);
            }
        }
    }

    private int[] extractCoordinatesFromPosition(String position) {
        return Arrays.stream(position.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    private String extractPositionFromCoordinates(int... coordinates) {
        return "" + coordinates[0] + "," + coordinates[1];
    }
}
