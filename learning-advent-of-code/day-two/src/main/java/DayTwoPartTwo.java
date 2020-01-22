import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DayTwoPartTwo {

    public static void main(String[] args) throws Exception {
        final String newContent = Files.readString(Paths.get(DayTwo.class.getResource("newInstructions.txt").toURI()));
        final String[] newSplit = newContent.split(",");
        final int[] newInstructions = Stream.of(newSplit).mapToInt(s -> Integer.parseInt(s)).toArray();

        final DayTwoPartTwo dayTwoPartTwo = new DayTwoPartTwo();

        dayTwoPartTwo.nounAndVerbCalculation(newInstructions);

    }

    private int[] nounAndVerbCalculation(final int[] newInstructions) {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j<=5; j++) {

                newInstructions[1] = i;
                newInstructions[2] = j;

                System.out.println("----------------");
                System.out.println("New Instruction Index 1: " + newInstructions[1]);
                System.out.println("New Instruction Index 1: " + newInstructions[2]);
            }
        }
        return newInstructions;
    }


}
