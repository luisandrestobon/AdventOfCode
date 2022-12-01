package year2021.day02.part1;

import year2021.day02.Instruction;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dive {
    private Map<String, Point> instructionMap;

    public Dive() {
        instructionMap = new HashMap<>();
        instructionMap.put("forward", new Point(1, 0));
        instructionMap.put("down", new Point(0, 1));
        instructionMap.put("up", new Point(0, -1));
    }

    public int submarinePositionProduct(List<String> input) {
        Point initialPoint = new Point(0,0);
        input.forEach(instructionRaw -> {
            Instruction instruction = new Instruction(instructionRaw);
            Point instructionMapPoint = instructionMap.get(instruction.getInstructionName());
            Point translationPoint = new Point(instructionMapPoint.x * instruction.getInstructionNumber(), instructionMapPoint.y * instruction.getInstructionNumber());
            initialPoint.translate(translationPoint.x, translationPoint.y);
        });
        return initialPoint.x * initialPoint.y;
    }
}
