package year2021.day04.part2;

import year2021.day04.MutableBoolean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
    private List<MutableBoolean> slots;
    private List<Integer> numbers;
    private List<List<MutableBoolean>> slotsRows;
    private List<List<MutableBoolean>> slotsCols;
    private Map<Integer, MutableBoolean> bingoNumberMap;
    private Boolean alreadyWinner;
    private Integer snapshotSumUnmarkedNumbers;
    private Integer snapshotWinnerNumber;

    public Board(List<String> textNumbersMatrix, Map<Integer, MutableBoolean> bingoNumberMap) {
        this.bingoNumberMap = bingoNumberMap;
        this.slots = new ArrayList<>();
        this.numbers = new ArrayList<>();
        this.slotsRows = new ArrayList<>();
        this.slotsCols = new ArrayList<>();
        this.alreadyWinner = false;
        for (String textNumberRow : textNumbersMatrix) {
            int index = 0;
            textNumberRow = textNumberRow.trim();
            String[] strNumberRow = textNumberRow.split("( )+");
            List<MutableBoolean> row = new ArrayList<>();
            for (String strNumber : strNumberRow) {
                slots.add(bingoNumberMap.get(Integer.parseInt(strNumber)));
                row.add(bingoNumberMap.get(Integer.parseInt(strNumber)));
                if (slotsCols.size() < index + 1) {
                    slotsCols.add(new ArrayList<>());
                }
                List<MutableBoolean> col = slotsCols.get(index++);
                col.add(bingoNumberMap.get(Integer.parseInt(strNumber)));
                numbers.add(Integer.parseInt(strNumber));
            }
            slotsRows.add(row);
        }

    }

    public MutableBoolean getSlotByIndex(Integer index) {
        return slots.get(index);
    }

    private boolean listIsCrossed(List<MutableBoolean> list) {
        return list.stream().allMatch(MutableBoolean::getCrossed);
    }

    private boolean listsAreCrossed(List<List<MutableBoolean>> lists) {
        return lists.stream().anyMatch(this::listIsCrossed);
    }

    public boolean isWinner() {
        return listsAreCrossed(this.slotsCols) || listsAreCrossed(this.slotsRows);
    }

    public int sumUnmarkedNumbers() {
        return this.numbers.stream().filter(num -> !this.bingoNumberMap.get(num).getCrossed()).mapToInt(Integer::intValue).sum();
    }

    public Boolean getAlreadyWinner() {
        return alreadyWinner;
    }

    public void setAlreadyWinner(Boolean alreadyWinner, Integer winnerNumber) {
        this.alreadyWinner = alreadyWinner;
        if (alreadyWinner) {
            this.snapshotSumUnmarkedNumbers = sumUnmarkedNumbers();
            this.snapshotWinnerNumber = winnerNumber;
        }
    }

    public Integer getSnapshotSumUnmarkedNumbers() {
        return snapshotSumUnmarkedNumbers;
    }

    public Integer getSnapshotWinnerNumber() {
        return snapshotWinnerNumber;
    }
}
