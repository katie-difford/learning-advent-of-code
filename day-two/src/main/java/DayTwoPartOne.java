
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DayTwoPartOne {

    public static void main(String[] args) throws Exception {

        final String fileContent = Files.readString(Paths.get(DayTwoPartOne.class.getResource("instructions.txt").toURI()));
        final String[] split = fileContent.split(",");
        final int[] instructions = Stream.of(split).mapToInt(s -> Integer.parseInt(s)).toArray();

        final DayTwoPartOne dayTwoPartOne = new DayTwoPartOne();
        dayTwoPartOne.getTheNumberAtPositionOne(instructions);
    }

    public void getTheNumberAtPositionOne(final int[] instructions) {
        DayTwo.opcodeCalculation(instructions);
        System.out.println("--------------");
        System.out.println("Instruction at Position 0: " + instructions[0]);
        System.out.println("--------------");
    }

}