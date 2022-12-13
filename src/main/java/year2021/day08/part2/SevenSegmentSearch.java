package year2021.day08.part2;

import java.util.*;
import java.util.stream.Collectors;

public class SevenSegmentSearch {

    private final Map<String, Integer> patterns = new HashMap<>();

    public int addAllOutputValues(List<String> testList) {
        return testList.stream().map(this::getFourDigitNumber).reduce(0, Integer::sum);
    }

    private int getFourDigitNumber(String line) {
        String[] parts = line.split(" \\| ");
        String data = parts[0];
        String finalNumber = parts[1];
        populatePatternsMap(data);
        return obtainNumberFromString(finalNumber);
    }

    private void populatePatternsMap(String data) {
        patterns.clear();
        Set<String> dataSet = new HashSet<>(Arrays.asList(data.split(" ")));
        String number1 = setNumber1(dataSet);
        String number4 = setNumber4(dataSet);
        setNumber7(dataSet);
        setNumber8(dataSet);
        String number5 = setNumber5(dataSet, number1, number4);
        String number3 = setNumber3(dataSet, number1);
        setNumber2(dataSet, number3, number5);
        String number6 = setNumber6(dataSet, number1);
        String number0 = setNumber0(dataSet, number1, number4);
        setNumber9(dataSet, number0, number6);
    }

    private String setNumber0(Set<String> dataSet, String number1, String number4) {
        Set<String> subSet = getSubsetBySegments(dataSet, 6);
        String subSegment = substract(number4, number1);
        String number0 = subSet.stream().filter(str -> !isContained(str, subSegment)).findFirst().orElseThrow();
        number0 = orderString(number0);
        patterns.put(number0, 0);
        return number0;
    }

    private String setNumber1(Set<String> dataSet) {
        String number1 = getNumberBySegments(dataSet, 2);
        patterns.put(number1, 1);
        return number1;
    }

    private void setNumber2(Set<String> dataSet, String number3, String number5) {
        Set<String> subSet = getSubsetBySegments(dataSet, 5);
        String number2 = subSet.stream().map(this::orderString).filter(str -> !str.equals(number3) && !str.equals(number5)).findFirst().orElseThrow();
        patterns.put(number2, 2);
    }

    private String setNumber3(Set<String> dataSet, String number1) {
        Set<String> subSet = getSubsetBySegments(dataSet, 5);
        String number3 = subSet.stream().filter(str -> isContained(str, number1)).findFirst().orElseThrow();
        number3 = orderString(number3);
        patterns.put(number3, 3);
        return number3;
    }

    private String setNumber4(Set<String> dataSet) {
        String number4 = getNumberBySegments(dataSet, 4);
        patterns.put(number4, 4);
        return number4;
    }

    private String setNumber5(Set<String> dataSet, String number1, String number4) {
        Set<String> subSet = getSubsetBySegments(dataSet, 5);
        String subSegment = substract(number4, number1);
        String number5 = subSet.stream().filter(str -> isContained(str, subSegment)).findFirst().orElseThrow();
        number5 = orderString(number5);
        patterns.put(number5, 5);
        return number5;
    }

    private String setNumber6(Set<String> dataSet, String number1) {
        Set<String> subSet = getSubsetBySegments(dataSet, 6);
        String number6 = subSet.stream().filter(str -> !isContained(str, number1)).findFirst().orElseThrow();
        number6 = orderString(number6);
        patterns.put(number6, 6);
        return number6;
    }

    private void setNumber7(Set<String> dataSet) {
        String number7 = getNumberBySegments(dataSet, 3);
        patterns.put(number7, 7);
    }

    private void setNumber8(Set<String> dataSet) {
        String number8 = getNumberBySegments(dataSet, 7);
        patterns.put(number8, 8);
    }

    private void setNumber9(Set<String> dataSet, String number0, String number6) {
        Set<String> subSet = getSubsetBySegments(dataSet, 6);
        String number9 = subSet.stream().map(this::orderString).filter(str -> !str.equals(number0) && !str.equals(number6)).findFirst().orElseThrow();
        patterns.put(number9, 9);
    }

    private String getNumberBySegments(Set<String> dataSet, int segments) {
        String number = getSubsetBySegments(dataSet, segments).stream().findFirst().orElseThrow();
        return orderString(number);
    }

    private Set<String> getSubsetBySegments(Set<String> dataSet, int segments) {
        return dataSet.stream()
                .filter(str -> str.length() == segments)
                .collect(Collectors.toSet());
    }

    private String substract(String str1, String str2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(str1.split("")));
        Set<String> set2 = new HashSet<>(Arrays.asList(str2.split("")));
        return String.join("", set1.stream().filter(ch -> !set2.contains(ch)).toArray(String[]::new));
    }

    private boolean isContained(String str, String subStr) {
        Set<String> set = new HashSet<>(Arrays.asList(str.split("")));
        Set<String> subSet = new HashSet<>(Arrays.asList(subStr.split("")));
        return set.containsAll(subSet);
    }

    private int obtainNumberFromString(String line) {
        int output = 0;
        String[] digits = line.split(" ");
        for (int i = 0; i < digits.length; i++) {
            output += patterns.get(orderString(digits[i])) * (int) Math.pow(10, digits.length - i - 1);
        }
        return output;
    }

    private String orderString(String input) {
        return input.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
