public class DayTwo {

    public static int[] opcodeCalculation(final int[] instructions) {

        for (int offset = 0; offset < instructions.length; offset += 4) {
            boolean shouldContinue = instructionsToDecode(instructions, offset);
            if (!shouldContinue) {
                break;
            }
        }

        return instructions;
    }

    private static boolean instructionsToDecode(final int[] instructions, final int offset) {

        //gets operational code foe next group of four
        final int opcode = instructions[offset];
        int total;

        //if operational code is 99, then exit the operation
        if (opcode == 99) {
            return false;
        }

        //gets the next second position in the group of four by adding the offset to the first second position
        final int firstNumberPosition = instructions[1 + offset];

        //gets the next third position in the group of four by adding the offset to the first third position
        final int secondNumberPosition = instructions[2 + offset];

        //gets the number in the next second position
        final int firstNumber = instructions[firstNumberPosition];

        //gets the number in the next third position
        final int secondNumber = instructions[secondNumberPosition];


        if (opcode == 1) {
            //if operation code is 1, then add the first and second numbers together
            total = firstNumber + secondNumber;
        } else {
            //if the operation code is anything else, then multiply the first and second numbers together
            total = firstNumber * secondNumber;
        }

        //finds the next position to replace
        final int positionToReplace = instructions[3 + offset];

        //replaces the number in that positon with the total
        instructions[positionToReplace] = total;

        return true;
    }
}
