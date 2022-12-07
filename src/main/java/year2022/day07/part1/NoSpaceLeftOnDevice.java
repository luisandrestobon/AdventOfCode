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
            String[] words = line.split(" ");
            if (words[0].equals(Keywords.COMMAND.getText())) {
                processCommand(words);
            } else {
                processFileAndDirectory(words[0].equals(Keywords.DIR.getText()), words);
            }
        }
        getDirectorySize(root);
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
        String directory = words[2];
        if (directory.equals(Keywords.PREVIOUS_DIR.getText())) {
            actual = actual.getParent();
        } else if (directory.equals(Keywords.OUTMOST_DIR.getText())) {
            root = (root == null) ? new Node(Keywords.OUTMOST_DIR.getText(), 0L, true) : root;
            actual = root;
        } else {
            processFileAndDirectory(true, null, directory);
            actual = actual.getChildByName(directory);
        }
    }

    private void processFileAndDirectory(boolean isDirectory, String... words) {
        String name = words[1];
        List<Node> childs = actual.getChilds();
        if (childs == null) {
            childs = new ArrayList<>();
            actual.setChilds(childs);
        }
        Node child = actual.getChildByName(name);
        if (child == null) {
            // File or directory not registered
            long size = isDirectory ? 0L : Long.parseLong(words[0]);
            child = new Node(name, size, isDirectory);
            child.setParent(actual);
            childs.add(child);
        }
    }

    private long getDirectorySize(Node directory) {
        if (directory.getSize() != 0L) {
            directories.add(directory);
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
        directories.add(directory);
        return size;
    }

    private long getSumTotal() {
        long sum = 0L;
        for (Node directory : directories) {
            long size = directory.getSize();
            if (size <= MAX_SIZE) {
                sum += size;
            }
        }
        return sum;
    }

}
