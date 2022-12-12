package year2022.day11.part2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item {
    private final Map<Integer, Integer> modulusMap = new HashMap<>();

    public Item(int initialValue, List<Integer> testNumbers) {
        for (Integer testNumber : testNumbers) {
            modulusMap.put(testNumber, initialValue % testNumber);
        }
    }

    public void applyOperationAndTest(Operators operator, Integer operationConstant) {
        for (Map.Entry<Integer, Integer> entry : modulusMap.entrySet()) {
            int testNumber = entry.getKey();
            int modulus = entry.getValue();
            switch (operator) {
                case SUM:
                    modulus += operationConstant;
                    break;
                case MULTIPLY:
                    if (operationConstant == null) {
                        modulus *= modulus;
                    } else {
                        modulus *= operationConstant;
                    }
                    break;
                default:
                    throw new RuntimeException("This is not a valid case.");
            }
            modulus %= testNumber;
            modulusMap.put(testNumber, modulus);
        }
    }

    public Map<Integer, Integer> getModulusMap() {
        return modulusMap;
    }
}
