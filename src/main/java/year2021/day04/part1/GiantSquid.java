package year2021.day04.part1;

import year2021.day04.MutableBoolean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GiantSquid {
    private List<Integer> numberList;
    private Map<Integer, MutableBoolean> bingoNumberMap;
    private List<Board> boards;
    private Board winnerBoard;
    private Integer winnerNumber;

    public GiantSquid(List<String> list) {
        this.winnerBoard = null;
        this.winnerNumber = null;
        this.boards = new ArrayList<>();
        createBingoNumbers(list.get(0));
        List<String> textNumbersMatrix = new ArrayList<>();
        for (int i = 2; i < list.size(); i++) {
            if (list.get(i).length() > 0) {
                textNumbersMatrix.add(list.get(i));
            } else {
                this.boards.add(new Board(textNumbersMatrix, this.bingoNumberMap));
                textNumbersMatrix = new ArrayList<>();
            }
        }
        this.boards.add(new Board(textNumbersMatrix, this.bingoNumberMap));
    }

    private void createBingoNumbers(String line) {
        this.numberList = Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        this.bingoNumberMap = this.numberList.stream().collect(Collectors.toMap(number -> number, number -> new MutableBoolean(false)));
    }

    public void start() {
        for (Integer number: this.numberList) {
            MutableBoolean slot = this.bingoNumberMap.get(number);
            slot.setCrossed(true);
            for (Board board : this.boards) {
                if (board.isWinner()) {
                    this.winnerNumber = number;
                    this.winnerBoard = board;
                    return;
                }
            }
        }
    }

    public int getFinalScore() {
        return winnerBoard.sumUnmarkedNumbers() * winnerNumber;
    }
}
