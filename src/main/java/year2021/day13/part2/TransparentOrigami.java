package year2021.day13.part2;

import java.util.*;

public class TransparentOrigami {

    private Set<String> transparentPaper = new HashSet<>();
    private final List<String> folds = new ArrayList<>();
    private final int[] dimensions = { Integer.MIN_VALUE, Integer.MIN_VALUE };

    public List<String> visibleDots(List<String> testList) {
        initializeTransparentPaperAndFolds(testList);
        getDimensions();
        for (String fold : folds) {
            foldTransparentPaper(fold);
        }
        return showVisibleDots();
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

        if (foldInstructions[0].equals("x")) {
            dimensions[0] -= (offset + 1);
        } else {
            dimensions[1] -= (offset + 1);
        }
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

    private List<String> showVisibleDots() {
        List<String> visibleDots = new ArrayList<>();
        StringBuilder sb;
        for (int i = 0; i < dimensions[1]; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < dimensions[0]; j++) {
                String position = extractPositionFromCoordinates(j, i);
                sb.append(transparentPaper.contains(position) ? "#" : ".");
            }
            visibleDots.add(sb.toString());
        }
        return visibleDots;
    }

    private void getDimensions() {
        for (String position : transparentPaper) {
            int[] coordinates = extractCoordinatesFromPosition(position);
            dimensions[0] = Math.max(coordinates[0], dimensions[0]);
            dimensions[1] = Math.max(coordinates[1], dimensions[1]);
        }
        dimensions[0]++;
        dimensions[1]++;
    }
}
