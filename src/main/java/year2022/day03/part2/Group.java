package year2022.day03.part2;

import java.util.*;

public class Group {
    private final List<String> rucksacks = new ArrayList<>();
    private final Set<Character> items = new HashSet<>();

    public void addRucksack(String rucksack) {
        this.rucksacks.add(rucksack);
        for (char item : rucksack.toCharArray()) {
            this.items.add(item);
        }
    }

    public char getBadge() {
        Character badge = null;
        for (char item : this.items) {
            int count = 0;
            for (String rucksack : rucksacks) {
                if (rucksack.indexOf(item) >= 0) {
                    count++;
                }
            }
            if (count == 3) {
                badge = item;
                break;
            }
        }
        if (badge == null) {
            throw new RuntimeException("There is no 3 item badge");
        }
        return badge;
    }
}
