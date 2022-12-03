package year2022.day03.part1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<Character, Boolean> existingItemInFirstCompartment = new HashMap<>();
        int compartmentSize = rucksack.length() / 2;
        char[] firstCompartment = rucksack.substring(0, compartmentSize).toCharArray();
        char[] lastCompartment = rucksack.substring(compartmentSize).toCharArray();
        char duplicatedItem = ' ';
        for (int i = 0; i < compartmentSize; i++) {
            char firstCompartmentItem = firstCompartment[i];
            existingItemInFirstCompartment.put(firstCompartmentItem, true);
        }
        for (int i = 0; i < compartmentSize; i++) {
            char lastCompartmentItem = lastCompartment[i];
            if (existingItemInFirstCompartment.containsKey(lastCompartmentItem)) {
                duplicatedItem = lastCompartmentItem;
                break;
            }
        }
        return duplicatedItem;
    }
}
