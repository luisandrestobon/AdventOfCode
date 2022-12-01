package year2021.day05.part2;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HydrothermalVenture {
    private Map<String, Integer> overlapPoints;

    public long numberOfOverlapPointsWithDiagonal(List<String> list) {
        overlapPoints = new HashMap<>();
        List<Point[]> pairsOfPoints = list.stream().map(this::extractPointsFromTextline).collect(Collectors.toList());
        countOverlapPointsWithDiagonal(pairsOfPoints);
        return overlapPoints.entrySet().stream().filter(map -> map.getValue() > 1).count();
    }

    private Point[] extractPointsFromTextline(String line) {
        return Arrays.stream(line.split(" -> ")).map(text -> {
            String[] coordinates = text.split(",");
            return new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
        }).toArray(Point[]::new);
    }

    private void countOverlapPointsWithDiagonal(List<Point[]> pairsOfPoints) {
        pairsOfPoints.forEach(this::evaluatePointsWithDiagonal);
        List<Integer> collect = overlapPoints.entrySet().stream().map(item -> item.getValue()).collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(collect);
    }

    private void evaluatePointsWithDiagonal(Point[] pair) {
        int x0 = pair[0].x;
        int y0 = pair[0].y;
        int x1 = pair[1].x;
        int y1 = pair[1].y;
        if (x0 == x1 && y0 != y1) {
            // Vertical line
            final String xKey = Integer.toString(x0);
            IntStream.rangeClosed(y1 < y0 ? y1 : y0, y1 < y0 ? y0 : y1).boxed().forEach(y -> incrementMapCount(xKey + "," + y.toString()));
        } else if (x0 != x1 && y0 == y1) {
            // Horizontal line
            final String yKey = Integer.toString(y0);
            IntStream.rangeClosed(x1 < x0 ? x1 : x0, x1 < x0 ? x0 : x1).boxed().forEach(x -> incrementMapCount(x.toString() + "," + yKey));
        } else if (x0 == x1 && y0 == y1) {
            // Single point
            String key = Integer.toString(x0) + "," + Integer.toString(y0);
            incrementMapCount(key);
        } else if (x1 - x0 == y1 - y0) {
            // First quadrant
            List<Integer> x_range = IntStream.rangeClosed(x0 > x1 ? x1 : x0, x0 > x1 ? x0 : x1).boxed().collect(Collectors.toList());
            List<Integer> y_range = IntStream.rangeClosed(y0 > y1 ? y1 : y0, y0 > y1 ? y0 : y1).boxed().collect(Collectors.toList());
            for (int i = 0; i < x_range.size(); i++) {
                incrementMapCount(x_range.get(i).toString() + "," + y_range.get(i).toString());
            }
        } else if (x0 - x1 == y1 - y0) {
            // Second quadrant
            List<Integer> x_range = IntStream.rangeClosed(x0 > x1 ? x1 : x0, x0 > x1 ? x0 : x1).boxed().sorted(x0 > x1 ? Comparator.reverseOrder() : Comparator.naturalOrder()).collect(Collectors.toList());
            List<Integer> y_range = IntStream.rangeClosed(y0 > y1 ? y1 : y0, y0 > y1 ? y0 : y1).boxed().sorted(y0 > y1 ? Comparator.reverseOrder() : Comparator.naturalOrder()).collect(Collectors.toList());
            for (int i = 0; i < x_range.size(); i++) {
                incrementMapCount(x_range.get(i).toString() + "," + y_range.get(i).toString());
            }
        }
    }

    private void incrementMapCount(String key) {
        if (overlapPoints.containsKey(key)) {
            overlapPoints.put(key, overlapPoints.get(key) + 1);
        } else {
            overlapPoints.put(key, 1);
        }
    }
}
