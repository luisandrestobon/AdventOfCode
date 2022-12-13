package year2022.day13.part2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PacketPair {
    private final String left;
    private final String right;

    public PacketPair(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    private boolean isNumber(String side) {
        return !side.isEmpty() && !side.contains("[") && !side.contains("]") && !side.contains(",");
    }

    private List<String> extractList(String side) {
        Deque<String> queue = new ArrayDeque<>();
        String[] sideArray = side.split("");
        queue.offer(sideArray[0]);
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 1; i < sideArray.length; i++) {
            if (sideArray[i].equals("[")) {
                queue.offer("[");
                sb.append("[");
            } else if (sideArray[i].equals("]")) {
                queue.poll();
                if (!queue.isEmpty()) {
                    sb.append("]");
                } else {
                    list.add(sb.toString());
                }
            } else if (sideArray[i].equals(",") && queue.size() == 1) {
                list.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(sideArray[i]);
            }
        }
        return list;
    }

    public Boolean compareSides() {
        return compareSides(this.left, this.right);
    }

    private Boolean compareSides(String left, String right) {
        if (right.isEmpty() && left.isEmpty()) {
            return null;
        }
        if (right.isEmpty()) {
            return false;
        }
        if (left.isEmpty()) {
            return true;
        }
        if (isNumber(left) && isNumber(right)) {
            if (left.equals(right)) {
                return null;
            }
            return Integer.parseInt(left) < Integer.parseInt(right);
        }
        if (!isNumber(left) && !isNumber(right)) {
            List<String> leftList = extractList(left);
            List<String> rightList = extractList(right);
            int i = 0;
            while (i < leftList.size() && i < rightList.size()) {
                Boolean compare = compareSides(leftList.get(i), rightList.get(i));
                if (compare != null) {
                    return compare;
                }
                i++;
            }
            if (leftList.size() == rightList.size()) {
                return null;
            }
            return leftList.size() < rightList.size();
        }
        if (isNumber(left) && !isNumber(right)) {
            // Mixed types, convert left to list
            left = "[" + left + "]";
            return compareSides(left, right);
        }
        if (!isNumber(left) && isNumber(right)) {
            // Mixed types, convert right to list
            right = "[" + right + "]";
            return compareSides(left, right);
        }
        return null;
    }
}
