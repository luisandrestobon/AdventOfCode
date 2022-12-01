package year2021.day02.part2;

import year2021.day02.Instruction;
import year2021.day02.Point3D;

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

    public int submarinePositionWithAimProduct(List<String> input) {
        Point3D initialPoint = new Point3D();
        input.forEach(instructionRaw -> {
            Instruction instruction = new Instruction(instructionRaw);
            Point instructionMapPoint = instructionMap.get(instruction.getInstructionName());
            Point3D translationPoint = new Point3D(
                    instructionMapPoint.x * instruction.getInstructionNumber(),
                    instructionMapPoint.x * initialPoint.getZ() * instruction.getInstructionNumber(),
                    instructionMapPoint.y * instruction.getInstructionNumber());
            initialPoint.translate(translationPoint);
        });
        return initialPoint.getX() * initialPoint.getY();
    }
}
