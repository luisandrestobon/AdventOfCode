package year2021.day14.part2;

import java.util.*;

public class ExtendedPolymerization {

    private static final int MAX_STEPS = 40;
    private static final String INSERTION_RULE_SEPARATOR = " -> ";

    private final Map<String, String> pairInsertionRules = new HashMap<>();

    private Map<String, Long> pairCount = new HashMap<>();

    private Map<String, Long> letterCount = new HashMap<>();

    private String template;

    public long mostCommonMinusLeastCommon(List<String> testList) {
        initializePolymerization(testList);
        for (int i = 0; i < MAX_STEPS; i++) {
            executeStep();
        }
        for (Map.Entry<String, Long> entry : pairCount.entrySet()) {
            String pair = entry.getKey();
            String[] letters = pair.split("");
            long count = entry.getValue();
            for (String letter : letters) {
                if (!letterCount.containsKey(letter)) {
                    letterCount.put(letter, 0L);
                }
                letterCount.put(letter, letterCount.get(letter) + count);
            }
        }
        String[] templateLetters = template.split("");
        Map<String, Long> newLetterCount = new HashMap<>();
        for (Map.Entry<String, Long> entry : letterCount.entrySet()) {
            String letter = entry.getKey();
            long count = entry.getValue();
            if (!newLetterCount.containsKey(letter)) {
                newLetterCount.put(letter, 0L);
            }
            if (letter.equals(templateLetters[0]) || letter.equals(templateLetters[templateLetters.length - 1])) {
                newLetterCount.put(letter, (count + 1) / 2);
            } else {
                newLetterCount.put(letter, count / 2);
            }
        }
        letterCount = newLetterCount;
        long maxQuantity = letterCount.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElseThrow(NoSuchElementException::new);
        long minQuantity = letterCount.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElseThrow(NoSuchElementException::new);
        return maxQuantity - minQuantity;
    }

    private void executeStep() {
        Map<String, Long> newPairCount = new HashMap<>();
        for (Map.Entry<String, Long> entry : pairCount.entrySet()) {
            String pair = entry.getKey();
            String[] letters = pair.split("");
            long count = entry.getValue();
            String insertLetter = pairInsertionRules.get(pair);
            String firstPair = letters[0] + insertLetter;
            if (!newPairCount.containsKey(firstPair)) {
                newPairCount.put(firstPair, 0L);
            }
            newPairCount.put(firstPair, newPairCount.get(firstPair) + count);
            String secondPair = insertLetter + letters[1];
            if (!newPairCount.containsKey(secondPair)) {
                newPairCount.put(secondPair, 0L);
            }
            newPairCount.put(secondPair, newPairCount.get(secondPair) + count);
        }
        pairCount = newPairCount;
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
                pairCountFromTemplate(line);
            } else {
                // Are insertion rules
                addInsertionRule(line);
            }
        }
    }

    private void pairCountFromTemplate(String line) {
        for (int i = 1; i < line.length(); i++) {
            String pair = line.substring(i - 1, i + 1);
            if (!pairCount.containsKey(pair)) {
                pairCount.put(pair, 0L);
            }
            pairCount.put(pair, pairCount.get(pair) + 1);
        }
    }

    private void addInsertionRule(String line) {
        String[] rule = line.split(INSERTION_RULE_SEPARATOR);
        pairInsertionRules.put(rule[0], rule[1]);
    }
}