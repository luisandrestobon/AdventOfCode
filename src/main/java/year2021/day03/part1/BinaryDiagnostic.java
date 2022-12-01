package year2021.day03.part1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private String calculateGammaRate(List<String> input) {
        String gammaRate = "";
        int midBinaryNumbers = input.size() / 2;
        for (int i = 0; i < oneCount.size(); i++) {
            gammaRate += (oneCount.get(i) > midBinaryNumbers ? "1" : "0");
        }
        return gammaRate;
    }

    public int powerConsumption(List<String> input) {
        input.forEach(this::analyseBinary);
        String strGammaRate = calculateGammaRate(input);
        int gammaRate = Integer.parseInt(strGammaRate, 2);
        int epsilonRate = ~gammaRate + (int) Math.pow(2, strGammaRate.length());
        return gammaRate * epsilonRate;
    }
}
