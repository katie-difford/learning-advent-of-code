import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.util.LinkedList;
import java.util.stream.Stream;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.assertj.core.api.Assertions.assertThat;

public class DayThreePartOneTest {

    private static Stream<Data> data() {

        return Stream.of(
                new Data("R75, D30, R83, U83, L12, D49, R71, U7, L72, U62, R66, U55, R34, D71, R55, D58, R83", 159)
        );
    }

    @MethodSource("data")
    @ParameterizedTest
    void canGetTheClosestPointToZeroWhereTheTwoWiresCross(final Data data) {
        assertThat(DayThree.distanceCalculation(data.directions)).isEqualTo(data.distance);
    }

    @Test
    void canAddPointZeroAsTheFirstLocationInTheList() {
        Point point = new Point(0,0);
        LinkedList list = new LinkedList();
        list.add(point);

        assertThat(DayThree.addPointZeroAsFirstLocationInTheList()).isEqualTo(list);
    }

    @Test
    void splitTheValuesInTheListByIndividualInstructions() {
        String inputs = "R75, D30, R83, U83, L12";
        String[] splits = inputs.split(", ");

        assertThat(DayThree.canSplitTheListIntoIndividualInstructions(inputs)).isEqualTo(splits);
    }

    private static class Data {

        private String directions;
        private int distance;

        public Data(final String directions, final int distance) {

            this.directions = directions;
            this.distance = distance;
        }
    }
}
