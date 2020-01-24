import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DayTwoPartTwo {

    public static void main(String[] args) throws Exception {
        final String newContent = Files.readString(Paths.get(DayTwoPartOne.class.getResource("newInstructions.txt").toURI()));
        final String[] newSplit = newContent.split(",");
        final int[] newInstructions = Stream.of(newSplit).mapToInt(s -> Integer.parseInt(s)).toArray();

        final DayTwoPartTwo dayTwoPartTwo = new DayTwoPartTwo();
        dayTwoPartTwo.getTheNumbersInPositionOneAndTwoThatReturnTheDesiredValue(newInstructions);
    }

    private void setTheNewPositionsInInstructions(int[] newInstructions, int firstNewNumber, int secondNewNumber) {
        newInstructions[1] = firstNewNumber;
        newInstructions[2] = secondNewNumber;
    }

    private void getTheNumbersInPositionOneAndTwoThatReturnTheDesiredValue(final int[] instructions) {
        while(instructions[0] != 19690720) {
            for (int i = 0; i <= 5; i++) {
                for (int j = 0; j <= 5; j++) {
                    setTheNewPositionsInInstructions(instructions, i, j);
                    DayTwo.opcodeCalculation(instructions);
                }
            }

        }
    }

}
