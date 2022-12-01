package year2022.day01.part1;

import java.util.List;

public class CalorieCounting {
    public int totalCaloriesElfCarrying(List<String> input) {
        int maxCalories = Integer.MIN_VALUE;
        int sumCalories = 0;
        for (String calories: input){
            if (!calories.isEmpty()) {
                sumCalories += Integer.parseInt(calories);
            } else {
                maxCalories = Math.max(sumCalories, maxCalories);
                sumCalories = 0;
            }
        }
        return maxCalories;
    }
}
