package year2021.day03.part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BinaryDiagnostic {
    private Map<Integer, Integer> oneCount = new HashMap<>();

    private void analyseBinary(String binary) {
        for (int i = 0; i < binary.length(); i++) {
            int bit = Integer.parseInt(binary.substring(i, i+1));
            if (oneCount.containsKey(i)) {
                oneCount.put(i, oneCount.get(i) + bit);
            } else {
                oneCount.put(i, bit);
            }
        }
    }

    private String calculateOxygenGeneratorRating(List<String> input) {
        List<String> filteredInput = new ArrayList<>(input);
        filteredInput.forEach(this::analyseBinary);
        for (int i = 0; i < oneCount.size(); i++) {
            final int binaryNumbers = filteredInput.size();
            final Double midBinaryNumbers = filteredInput.size() / 2.0;
            final int i_final = i;
            filteredInput = filteredInput.stream()
                    .filter(binary -> {

                                return (binary.substring(i_final, i_final + 1).equals("1") && oneCount.get(i_final) >= midBinaryNumbers) ||
                                        (binary.substring(i_final, i_final + 1).equals("0") && (binaryNumbers - oneCount.get(i_final)) > midBinaryNumbers);
                            }
                    )
                    .collect(Collectors.toList());
            if(filteredInput.size() < 2) {
                return filteredInput.get(0);
            }
            oneCount.clear();
            filteredInput.forEach(this::analyseBinary);
        }
        return filteredInput.get(0);
    }

    private String calculateCO2ScrubberRating(List<String> input) {
        List<String> filteredInput = new ArrayList<>(input);
        filteredInput.forEach(this::analyseBinary);
        for (int i = 0; i < oneCount.size(); i++) {
            final int binaryNumbers = filteredInput.size();
            final Double midBinaryNumbers = filteredInput.size() / 2.0;
            final int i_final = i;
            filteredInput = filteredInput.stream()
                    .filter(binary -> {

                                return (binary.substring(i_final, i_final + 1).equals("1") && oneCount.get(i_final) < midBinaryNumbers) ||
                                        (binary.substring(i_final, i_final + 1).equals("0") && (binaryNumbers - oneCount.get(i_final)) <= midBinaryNumbers);
                            }
                    )
                    .collect(Collectors.toList());
            if(filteredInput.size() < 2) {
                return filteredInput.get(0);
            }
            oneCount.clear();
            filteredInput.forEach(this::analyseBinary);
        }
        return filteredInput.get(0);
    }

    public int lifeSupportRating(List<String> input) {
        String oxygenGeneratorRating = calculateOxygenGeneratorRating(input);
        String CO2ScrubberRating = calculateCO2ScrubberRating(input);
        return Integer.parseInt(oxygenGeneratorRating, 2) * Integer.parseInt(CO2ScrubberRating, 2);
    }
}
