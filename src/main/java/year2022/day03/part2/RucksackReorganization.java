package year2022.day03.part2;

import java.util.*;

public class RucksackReorganization {

    private static final int NUMBER_OF_ELVES_BY_GROUP = 3;
    public int sumPrioritiesGroupItemTypes(List<String> testList) {
        List<Group> groups = new ArrayList<>();
        int sumPriorities = 0;
        for (int i = 0; i < testList.size(); i++) {
            String rucksack = testList.get(i);
            int groupId = i / NUMBER_OF_ELVES_BY_GROUP;
            if (i % NUMBER_OF_ELVES_BY_GROUP == 0) {
                groups.add(new Group());
            }
            groups.get(groupId).addRucksack(rucksack);
        }
        for (Group group : groups) {
            sumPriorities += getItemPriority(group.getBadge());
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

}
