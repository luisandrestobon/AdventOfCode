package year2022.day02.part1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RockPaperScissors {

    private final Map<String, Integer> scoreByMove = new HashMap<>() {{
        put("X", 1);
        put("Y", 2);
        put("Z", 3);
    }};

    private final Map<String, Integer> scoreByRound = new HashMap<>() {{
        put("A Z", 0);
        put("B X", 0);
        put("C Y", 0);
        put("A X", 3);
        put("B Y", 3);
        put("C Z", 3);
        put("A Y", 6);
        put("B Z", 6);
        put("C X", 6);
    }};
    public int getTotalScore(List<String> input) {
        int totalScore = 0;
        for (String round : input) {
            totalScore += getRoundTotalScore(round);
        }
        return totalScore;
    }

    private int getRoundTotalScore(String round) {
        String myMove = round.split(" ")[1];
        int myMoveScore = scoreByMove.get(myMove);
        int myRoundScore = scoreByRound.get(round);
        return myMoveScore + myRoundScore;
    }
}
