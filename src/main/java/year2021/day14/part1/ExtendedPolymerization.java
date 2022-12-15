package year2021.day14.part1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExtendedPolymerization {

    private static final int MAX_STEPS = 10;
    private static final String INSERTION_RULE_SEPARATOR = " -> ";

    private final Map<String, String> pairInsertionRules = new HashMap<>();

    private String template;

    public long mostCommonMinusLeastCommon(List<String> testList) {
        initializePolymerization(testList);
        for (int i = 0; i < MAX_STEPS; i++) {
            executeStep();
        }
        Map<String, Long> letterCount = Arrays.stream(template.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long maxQuantity = letterCount.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElseThrow(NoSuchElementException::new);
        long minQuantity = letterCount.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElseThrow(NoSuchElementException::new);
        return maxQuantity - minQuantity;
    }

    private void executeStep() {
        List<String> pairList = pairListFromTemplate();
        List<String> insertPairList = new ArrayList<>();
        for (String pair : pairList) {
            String[] letters = pair.split("");
            String insertLetter = pairInsertionRules.get(pair);
            insertPairList.add(letters[0] + insertLetter + letters[1]);
        }
        updateTemplate(insertPairList);
    }

    private void updateTemplate(List<String> insertPairList) {
        StringBuilder sb = new StringBuilder();
        sb.append(insertPairList.get(0));
        for (int i = 1; i < insertPairList.size(); i++) {
            String pair = insertPairList.get(i).substring(1, 3);
            sb.append(pair);
        }
        template = sb.toString();
    }

    private void initializePolymerization(List<String> testList) {
        boolean areInsertionRules = false;
        for (String line : testList) {
            if (line.isEmpty()) {
                // Change from template to insertion rules
                areInsertionRules = true;
            } else if (!areInsertionRules) {
                // Is template
                template = line;
            } else {
                // Are insertion rules
                addInsertionRule(line);
            }
        }
    }

    private void addInsertionRule(String line) {
        String[] rule = line.split(INSERTION_RULE_SEPARATOR);
        pairInsertionRules.put(rule[0], rule[1]);
    }

    private List<String> pairListFromTemplate() {
        List<String> pairList = new ArrayList<>();
        for (int i = 1; i < template.length(); i++) {
            String pair = template.substring(i - 1, i + 1);
            pairList.add(pair);
        }
        return pairList;
    }
}