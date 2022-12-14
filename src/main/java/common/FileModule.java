package common;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileModule {
    public static List<Integer> file2IntegerList(String filename) {
        List<Integer> list = new ArrayList<>();
        try {
            Path path = Paths.get(filename);
            String currentLine;
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                while((currentLine = reader.readLine()) != null) {
                    list.add(Integer.parseInt(currentLine));
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static int[][] file2IntegerMatrix(String filename, int rowNumber, int columnNumber) {
        int[][] array = new int[rowNumber][columnNumber];
        try {
            Path path = Paths.get(filename);

            String currentLine;
            int i = 0;
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                while((currentLine = reader.readLine()) != null) {
                    for (int j = 0; j < currentLine.length(); j++) {
                        array[i][j] = Integer.parseInt(currentLine.substring(j, j + 1));
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
        return array;
    }

    public static int[][] file2IntegerMatrix(String filename) {
        List<List<Integer>> matrixList = new ArrayList<>();
        try {
            Path path = Paths.get(filename);

            String currentLine;
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                while((currentLine = reader.readLine()) != null) {
                    matrixList.add(Arrays.stream(currentLine.split("")).map(Integer::parseInt).collect(Collectors.toList()));
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
        int[][] matrix = new int[matrixList.size()][matrixList.get(0).size()];
        for (int i = 0; i < matrixList.size(); i++) {
            int[] row = matrixList.get(i).stream().mapToInt(Integer::intValue).toArray();
            matrix[i] = row;
        }
        return matrix;
    }

    public static List<String> file2StringList(String filename) {
        List<String> list = new ArrayList<>();
        try {
            Path path = Paths.get(filename);
            list = Files.readAllLines(path);
        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static String file2String(String filename) {
        String line = null;
        try {
            Path path = Paths.get(filename);
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
        return line;
    }
}
