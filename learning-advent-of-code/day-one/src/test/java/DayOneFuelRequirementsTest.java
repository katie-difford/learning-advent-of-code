import org.junit.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertEquals;

class DayOneFuelRequirementsTest {

    DayOneFuelRequirements dayOneFuelRequirements = new DayOneFuelRequirements();

    @Test
    void canDivideNumberByThree() {
        int number = 6;
        int numberDividedByThree = dayOneFuelRequirements.dividingByThree(number);

        assertEquals(2, numberDividedByThree);
    }

    @Test
    void canRoundANumberDownAfterDividingByThree() {
        double number = 7.78;
        double numberRoundedDown = dayOneFuelRequirements.roundingDown(number);

        assertEquals(7.0, numberRoundedDown);
    }

    @Test
    void canSubtractTwo() {
        int number = 11;
        int numberMinusTwo = dayOneFuelRequirements.subtractingTwo(number);

        assertEquals(9, numberMinusTwo);
    }

    @Test
    void canReturnTheTotal() throws IOException {

        int totalFuelRequired = dayOneFuelRequirements.canLoopThroughMultipleValuesAndAddToTotal();

        assertEquals(25, totalFuelRequired);
    }

    @Test
    void canAddValuesToAList() {
        List<Integer> listOfModules = dayOneFuelRequirements.canAddValuesToList(1234);

        assertEquals(1, listOfModules.size());
    }
}