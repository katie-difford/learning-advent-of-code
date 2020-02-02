import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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

        for (int i = 0; i <= 99; i++) {
            for (int j = 0; j <= 99; j++) {

                final int[] current = Arrays.copyOf(instructions, instructions.length);
                setTheNewPositionsInInstructions(current, i, j);
                DayTwo.opcodeCalculation(current);

                if(current[0] == 19690720) {
                    System.out.println(String.format("i: %d, j: %d", i, j));
                    int answer = 100 * i + j;
                    System.out.println("Answer is: " + answer);
                    break;
                }
            }
        }
    }

}
