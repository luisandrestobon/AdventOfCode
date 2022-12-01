package year2022.day01.part2;

import java.util.List;

public class CalorieCounting {

    private static final int NUMBER_OF_ELVES = 3;
    public int totalCaloriesTopThreeElfCarrying(List<String> input) {
        input.add("");
        Node head = new Node(null);
        int sumCalories = 0;
        for (String calories: input){
            if (!calories.isEmpty()) {
                sumCalories += Integer.parseInt(calories);
            } else {
                addingCalorieToLinkedList(head, sumCalories);
                sumCalories = 0;
            }
        }
        return getTopSumCalories(head);
    }

    private int getTopSumCalories(Node head) {
        Node actual = head.getNext();
        int count = 0;
        int topSumCalories = 0;
        while (count < NUMBER_OF_ELVES && actual.getNext() != null) {
            topSumCalories += (int) actual.getValue();
            actual = actual.getNext();
            count++;
        }
        return topSumCalories;
    }

    private void addingCalorieToLinkedList(Node head, int calories) {
        int count = 0;
        Node previous = head;
        Node actual = head.getNext();
        while (count < NUMBER_OF_ELVES) {
            if (actual == null || calories > (int) actual.getValue()) {
                Node newNode = new Node(calories);
                newNode.setNext(previous.getNext());
                previous.setNext(newNode);
                break;
            }
            previous = actual;
            actual = actual.getNext();
            count++;
        }
    }
}
