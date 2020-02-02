import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;
import static java.math.RoundingMode.DOWN;

public class DayOneFuelRequirements {

    private List<Integer> listOfModules = new ArrayList<>();

    public int canLoopThroughMultipleValuesAndAddToTotal() throws IOException {

        int total = 0;

        try(BufferedReader br = new BufferedReader(new FileReader("resources/modules.txt"))) {
            for(String line; (line = br.readLine()) != null; ) {
                System.out.println(line);
                int dividedByThree = dividingByThree(parseInt(line));
                int roundedDown = roundingDown(dividedByThree);
                int minusTwo = subtractingTwo(roundedDown);
                total += minusTwo;
            }
        }

        System.out.println("Total: " + total);
        return total;
    }

    int dividingByThree(int number) {
        return number / 3;
    }

    int roundingDown(double numberDividedByThree) {
        BigDecimal originalNumber = new BigDecimal(numberDividedByThree);
        BigDecimal roundedDown = originalNumber.setScale(0, DOWN);

        return roundedDown.intValue();
    }

    int subtractingTwo(int numberRoundedDown) {
        return numberRoundedDown - 2;
    }

    public List<Integer> canAddValuesToList(int valueToAdd) {
        listOfModules.add(valueToAdd);
        return listOfModules;
    }
}
