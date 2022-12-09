package year2022.day09.part2;

import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class RopeBridge {

    private static final int NUMBER_OF_KNOTS = 10;
    private final Point headPoint = new Point();
    private final List<Point> tailPoints = new ArrayList<>();
    private final Set<String> positionsVisited = new HashSet<>();

    public int positionsVisitedAtLeastOnceTenKnots(List<String> testList) {
        // Initialize (NUMBER_OF_KNOTS - 1) knots
        for (int i = 0; i < NUMBER_OF_KNOTS - 1; i++) {
            tailPoints.add(new Point());
        }
        positionsVisited.add(getCoordinates(tailPoints.get(NUMBER_OF_KNOTS - 2)));
        List<Movement> movements = testList.stream().map(s -> s.split(" ")).map(Movement::new).collect(Collectors.toList());
        for (Movement movement : movements) {
            executeMovement(movement);
        }
        return positionsVisited.size();
    }

    private void executeMovement(Movement movement) {
        Motions motion = movement.getMotion();
        int steps = movement.getSteps();
        for (int i = 0; i < steps; i++) {
            executeHeadStep(motion);
            executeKnotSteps();
        }
    }

    private void executeHeadStep(Motions motion) {
        headPoint.translate(motion.getDeltaX(), motion.getDeltaY());
    }

    private void executeKnotSteps() {
        Point actualHeadPoint = headPoint;
        for (Point knot : tailPoints) {
            if (actualHeadPoint.equals(knot)) {
                break;
            }
            List<Point> adjacentTailPoints = getAdjacentPoints(knot, null);
            List<Point> adjacentStraightHeadPoints = getAdjacentPoints(actualHeadPoint, false);
            List<Point> adjacentDiagonalHeadPoints = getAdjacentPoints(actualHeadPoint, true);
            boolean found = false;
            if (!adjacentStraightHeadPoints.contains(knot) && !adjacentDiagonalHeadPoints.contains(knot)) {
                for (Point point : adjacentTailPoints) {
                    if (adjacentStraightHeadPoints.contains(point)) {
                        knot.move(point.x, point.y);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    for (Point point : adjacentTailPoints) {
                        if (adjacentDiagonalHeadPoints.contains(point)) {
                            knot.move(point.x, point.y);
                            break;
                        }
                    }
                }
            }
            actualHeadPoint = knot;
        }
        positionsVisited.add(getCoordinates(tailPoints.get(NUMBER_OF_KNOTS - 2)));
    }

    private List<Point> getAdjacentPoints(Point point, Boolean diagonalOrStraight) {
        List<Point> adjacentPoints = new ArrayList<>();
        if (diagonalOrStraight == null || diagonalOrStraight) {
            adjacentPoints.addAll(Arrays.asList(
                    // Diagonal Up Right
                    new Point(
                            point.x + Motions.U.getDeltaX() + Motions.R.getDeltaX(),
                            point.y + Motions.U.getDeltaY() + Motions.R.getDeltaY()
                    ),
                    // Diagonal Up Left
                    new Point(
                            point.x + Motions.U.getDeltaX() + Motions.L.getDeltaX(),
                            point.y + Motions.U.getDeltaY() + Motions.L.getDeltaY()
                    ),
                    // Diagonal Down Right
                    new Point(
                            point.x + Motions.D.getDeltaX() + Motions.R.getDeltaX(),
                            point.y + Motions.D.getDeltaY() + Motions.R.getDeltaY()
                    ),
                    // Diagonal Down Left
                    new Point(
                            point.x + Motions.D.getDeltaX() + Motions.L.getDeltaX(),
                            point.y + Motions.D.getDeltaY() + Motions.L.getDeltaY()
                    )
            ));
        }
        if (diagonalOrStraight == null || !diagonalOrStraight) {
            adjacentPoints.addAll(Arrays.asList(
                    // Up
                    new Point(
                            point.x + Motions.U.getDeltaX(),
                            point.y + Motions.U.getDeltaY()
                    ),
                    // Down
                    new Point(
                            point.x + Motions.D.getDeltaX(),
                            point.y + Motions.D.getDeltaY()
                    ),
                    // Right
                    new Point(
                            point.x + Motions.R.getDeltaX(),
                            point.y + Motions.R.getDeltaY()
                    ),
                    // Left
                    new Point(
                            point.x + Motions.L.getDeltaX(),
                            point.y + Motions.L.getDeltaY()
                    )
            ));
        }
        return adjacentPoints;
    }

    private String getCoordinates(Point point) {
        return "" + point.x + "," + point.y;
    }
}
