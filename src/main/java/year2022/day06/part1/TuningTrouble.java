package year2022.day06.part1;

import java.util.*;

public class TuningTrouble {

    private static final int MAX_MARKER_SIZE = 4;

    public int[] numberCharactersNeededList(List<String> testList) {
        int[] output = new int[testList.size()];
        for (int i = 0; i < testList.size(); i++) {
            output[i] = numberCharactersNeeded(testList.get(i));
        }
        return output;
    }

    private int numberCharactersNeeded(String streamLine) {
        char[] stream = streamLine.toCharArray();
        Deque<Character> marker = new ArrayDeque<>();
        for (int i = 0; i < stream.length; i++) {
            addCharacterToMarker(marker, stream[i]);
            if (areAllDifferent(marker)) {
                return i + 1;
            }
        }
        throw new RuntimeException("There isn't a valid marker");
    }

    private void addCharacterToMarker(Deque<Character> marker, char character) {
        marker.offer(character);
        if (marker.size() > MAX_MARKER_SIZE) {
            marker.poll();
        }
    }

    private boolean areAllDifferent(Deque<Character> marker) {
        if (marker.size() < MAX_MARKER_SIZE) {
            return false;
        }
        Map<Character, Integer> numberOfCharacters = new HashMap<>();
        for (char character : marker) {
            if (!numberOfCharacters.containsKey(character)) {
                numberOfCharacters.put(character, 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
