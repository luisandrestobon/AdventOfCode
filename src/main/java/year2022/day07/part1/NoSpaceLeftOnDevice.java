package year2022.day07.part1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoSpaceLeftOnDevice {

    private static final long MAX_SIZE = 100_000L;
    private Node root = null;
    private Node actual = null;
    private final Set<Node> directories = new HashSet<>();
    public long sumDirectoriesTotalSizes(List<String> testList) {
        for (String line : testList) {
            //System.out.println(line);
            String[] words = line.split(" ");
            if (words[0].equals(Keywords.COMMAND.getText())) {
                // It's a command
                processCommand(words);
            } else {
                processFilesAndDirectories(words);
            }
        }
        return getSumTotal();
    }

    private void processCommand(String[] words) {
        Keywords command = Keywords.valueOf(words[1].toUpperCase());
        switch (command) {
            case CD:
                moveToDirectory(words);
                break;
            case LS:
                break;
            default:
                throw new RuntimeException("There is no such command");
        }
    }

    private void moveToDirectory(String[] words) {
        if (words[2].equals(Keywords.PREVIOUS_DIR.getText())) {
            // Go to previous directory
            actual = actual.getParent();
        } else if (words[2].equals(Keywords.OUTMOST_DIR.getText())) {
            // Go to outmost directory
            if (root == null) {
                // Initial command
                root = new Node(Keywords.OUTMOST_DIR.getText(), 0L, true);
            }
            actual = root;
            directories.add(root);
        } else {
            // Go into x directory
            String directory = words[2];
            Node child = new Node(directory, 0L, true);
            List<Node> childs = actual.getChilds();
            if (childs == null) {
                childs = new ArrayList<>();
                actual.setChilds(childs);
            }
            if (childs.contains(child)) {
                child = childs.get(childs.indexOf(child));
            } else {
                childs.add(child);
                child.setParent(actual);
            }
            actual = child;
            directories.add(child);
        }
    }

    private void processFilesAndDirectories(String[] words) {
        if (actual.getChilds() == null) {
            actual.setChilds(new ArrayList<>());
        }
        String name = words[1];
        long size = 0L;
        if (!words[0].equals(Keywords.DIR.getText())) {
            size = Long.parseLong(words[0]);
        }
        Node child = new Node(name, size, false);
        if (!actual.getChilds().contains(child)) {
            actual.getChilds().add(child);
            child.setParent(actual);
        }
    }

    private long getSumTotal() {
        long sum = 0L;
        for (Node directory : directories) {
            long size = getDirectorySize(directory);
            if (size <= MAX_SIZE) {
                sum += size;
            }
        }
        return sum;
    }

    private long getDirectorySize(Node directory) {
        if (directory.getSize() != 0L) {
            return directory.getSize();
        }
        long size = 0L;
        for (Node child : directory.getChilds()) {
            if (child.isDirectory()) {
                size += getDirectorySize(child);
            } else {
                size += child.getSize();
            }
        }
        directory.setSize(size);
        return size;
    }
}
