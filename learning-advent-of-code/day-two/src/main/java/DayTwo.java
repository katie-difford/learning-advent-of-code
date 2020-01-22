
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DayTwo {

    public static void main(String[] args) throws Exception {

        final String fileContent = Files.readString(Paths.get(DayTwo.class.getResource("instructions.txt").toURI()));
        final String[] split = fileContent.split(",");
        final int[] instructions = Stream.of(split).mapToInt(s -> Integer.parseInt(s)).toArray();

        final DayTwo dayTwo = new DayTwo();
        dayTwo.opcodeCalculation(instructions);

        System.out.println("--------------");
        System.out.println("Instruction at Position 0: " + instructions[0]);
        System.out.println("--------------");

    }

    public int[] opcodeCalculation(final int[] instructions) {

        for (int offset = 0; offset < instructions.length; offset += 4) {
            boolean shouldContinue = instructionsToDecode(instructions, offset);
            if (!shouldContinue) {
                break;
            }
        }

        return instructions;
    }

    private boolean instructionsToDecode(final int[] instructions, final int offset) {

        final int opcode = instructions[offset];
        int total;

        if (opcode == 99) {
            return false;
        }

        final int firstNumberPosition = instructions[1 + offset];
        final int secondNumberPosition = instructions[2 + offset];

        final int firstNumber = instructions[firstNumberPosition];
        final int secondNumber = instructions[secondNumberPosition];

        if (opcode == 1) {
            total = firstNumber + secondNumber;
        } else {
            total = firstNumber * secondNumber;
        }

        final int positionToReplace = instructions[3 + offset];

        instructions[positionToReplace] = total;

        return true;
    }
}