package year2022.day09.part1;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class RopeBridge {
    private final Point headPoint = new Point();
    private final Point tailPoint = new Point();
    private final Set<String> positionsVisited = new HashSet<>();

    public int positionsVisitedAtLeastOnce(List<String> testList) {
        positionsVisited.add(getCoordinates(tailPoint));
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
            executeTailStep();
        }
    }

    private void executeHeadStep(Motions motion) {
        headPoint.translate(motion.getDeltaX(), motion.getDeltaY());
    }

    private void executeTailStep() {
        if (headPoint.equals(tailPoint)) {
            return;
        }
        List<Point> adjacentTailPoints = getAdjacentPoints(tailPoint, null);
        List<Point> adjacentStraightHeadPoints = getAdjacentPoints(headPoint, false);
        List<Point> adjacentDiagonalHeadPoints = getAdjacentPoints(headPoint, true);
        if (!adjacentStraightHeadPoints.contains(tailPoint) && !adjacentDiagonalHeadPoints.contains(tailPoint)) {
            for (Point point : adjacentTailPoints) {
                if (adjacentStraightHeadPoints.contains(point)) {
                    tailPoint.move(point.x, point.y);
                    positionsVisited.add(getCoordinates(tailPoint));
                    return;
                }
            }
            for (Point point : adjacentTailPoints) {
                if (adjacentDiagonalHeadPoints.contains(point)) {
                    tailPoint.move(point.x, point.y);
                    positionsVisited.add(getCoordinates(tailPoint));
                    return;
                }
            }
        }
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
