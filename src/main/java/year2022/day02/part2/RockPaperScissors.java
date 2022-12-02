package year2022.day02.part2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RockPaperScissors {

    private final Map<String, Integer> scoreByMove = new HashMap<>() {{
        put("A X", 3);
        put("A Y", 1);
        put("A Z", 2);
        put("B X", 1);
        put("B Y", 2);
        put("B Z", 3);
        put("C X", 2);
        put("C Y", 3);
        put("C Z", 1);
    }};

    private final Map<String, Integer> scoreByRound = new HashMap<>() {{
        put("X", 0);
        put("Y", 3);
        put("Z", 6);
    }};
    public int getRealTotalScore(List<String> input) {
        int totalScore = 0;
        for (String round : input) {
            totalScore += getRoundTotalScore(round);
        }
        return totalScore;
    }

    private int getRoundTotalScore(String round) {
        String expectedResult = round.split(" ")[1];
        int myMoveScore = scoreByMove.get(round);
        int myRoundScore = scoreByRound.get(expectedResult);
        return myMoveScore + myRoundScore;
    }
}
