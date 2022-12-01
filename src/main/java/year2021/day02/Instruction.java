package year2021.day02;

public class Instruction {
    private String instructionName;
    private Integer instructionNumber;

    public Instruction(String instructionRaw) {
        decodeInstruction(instructionRaw);
    }

    public String getInstructionName() {
        return instructionName;
    }

    public Integer getInstructionNumber() {
        return instructionNumber;
    }

    public void decodeInstruction(String instructionRaw) {
        String[] instructions = instructionRaw.split(" ");
        this.instructionName = instructions[0];
        this.instructionNumber = Integer.parseInt(instructions[1]);
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "instructionName='" + instructionName + '\'' +
                ", instructionNumber=" + instructionNumber +
                '}';
    }
}
