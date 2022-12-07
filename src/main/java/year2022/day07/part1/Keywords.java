package year2022.day07.part1;

public enum Keywords {
    COMMAND("$"),
    OUTMOST_DIR("/"),
    PREVIOUS_DIR(".."),
    CD("cd"),
    LS("ls"),
    DIR("dir");

    private final String text;

    Keywords(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
