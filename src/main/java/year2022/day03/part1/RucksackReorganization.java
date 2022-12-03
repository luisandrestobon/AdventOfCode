package year2022.day03.part1;

import java.util.*;

public class RucksackReorganization {
    public int sumPrioritiesItemTypes(List<String> testList) {
        int sumPriorities = 0;
        for (String rucksack : testList) {
            sumPriorities += getItemPriority(getDuplicatedItem(rucksack));
        }
        return sumPriorities;
    }

    private int getItemPriority(char duplicatedItem) {
        if (duplicatedItem > 96) {
            // lowercase letter
            return duplicatedItem - 96;
        }
        // uppercase letter
        return duplicatedItem - 38;
    }

    private char getDuplicatedItem(String rucksack) {
        Set<Character> existingItemInFirstCompartment = new HashSet<>();
        int compartmentSize = rucksack.length() / 2;
        char[] firstCompartment = rucksack.substring(0, compartmentSize).toCharArray();
        char[] lastCompartment = rucksack.substring(compartmentSize).toCharArray();
        char duplicatedItem = ' ';
        for (int i = 0; i < compartmentSize; i++) {
            char firstCompartmentItem = firstCompartment[i];
            existingItemInFirstCompartment.add(firstCompartmentItem);
        }
        for (int i = 0; i < compartmentSize; i++) {
            char lastCompartmentItem = lastCompartment[i];
            if (existingItemInFirstCompartment.contains(lastCompartmentItem)) {
                duplicatedItem = lastCompartmentItem;
                break;
            }
        }
        return duplicatedItem;
    }
}
