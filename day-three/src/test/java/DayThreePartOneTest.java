import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.util.LinkedList;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DayThreePartOneTest {

    private static Stream<Data> data() {

        return Stream.of(
                new Data(
                        "R75, D30, R83, U83, L12, D49, R71, U7, L72",
                        "U62, R66, U55, R34, D71, R55, D58, R83",
                        159)
        );
    }

    @MethodSource("data")
    @ParameterizedTest
    void canGetTheClosestPointToZeroWhereTheTwoWiresCross(final Data data) {
        assertThat(DayThree.distanceCalculationForWire(data.firstWireDirections, data.secondWireDirections)).isEqualTo(data.distance);
    }

    @Test
    void canAddPointZeroAsTheFirstLocationInTheList() {
        Point point = new Point(0, 0);
        LinkedList list = new LinkedList();
        list.add(point);

        assertThat(DayThree.addPointZeroAsFirstLocationInTheList(list)).isEqualTo(list);
    }

    @Test
    void splitTheValuesInTheListByIndividualInstructions() {
        String inputs = "R75, D30, R83, U83, L12";
        String[] splits = inputs.split(", ");

        assertThat(DayThree.canSplitTheListIntoIndividualInstructions(inputs)).isEqualTo(splits);
    }

    @Test
    void canGetDirectionFromIndividualInstruction() {
        String input = "R75";
        String direction = input.substring(0, 1);

        assertThat(DayThree.splitIndividualInstructionIntoDirection(input)).isEqualTo(direction);
    }

    @Test
    void canGetDistanceFromIndividualInstruction() {
        String input = "R75";
        String distance = input.substring(1);

        assertThat(DayThree.splitIndividualInstructionIntoDistance(input)).isEqualTo(distance);
    }

    @Test
    void canWorkOutTheNewCoordinatesOfTheWireWhenGoingRight() {
        Point point = new Point(0, 10);
        Point anotherPoint = new Point(100, 100);

        LinkedList list = new LinkedList();
        list.add(point);
        list.add(anotherPoint);

        String distance = "75";

        Point newPoint = new Point(175, 100);

        assertThat(DayThree.workOutNewCoordinatesOfTheWireWhenGoingRight(1, list, distance)).isEqualTo(newPoint);
    }

    @Test
    void canWorkOutTheNewCoordinatesOfTheWireWhenGoingLeft() {
        Point point = new Point(75, 10);
        Point anotherPoint = new Point(100, 100);

        LinkedList list = new LinkedList();
        list.add(point);
        list.add(anotherPoint);

        String distance = "10";

        Point newPoint = new Point(90, 100);

        assertThat(DayThree.workOutNewCoordinatesOfTheWireWhenGoingLeft(1, list, distance)).isEqualTo(newPoint);
    }

    @Test
    void canWorkOutTheNewCoordinatesOfTheWireWhenGoingUp() {
        Point point = new Point(75, 10);
        Point anotherPoint = new Point(100, 100);

        LinkedList list = new LinkedList();
        list.add(point);
        list.add(anotherPoint);

        String distance = "50";

        Point newPoint = new Point(100, 150);

        assertThat(DayThree.workOutNewCoordinatesOfTheWireWhenGoingUp(1, list, distance)).isEqualTo(newPoint);
    }

    @Test
    void canWorkOutTheNewCoordinatesOfTheWireWhenGoingDown() {
        Point point = new Point(75, 60);
        Point anotherPoint = new Point(100, 100);
        LinkedList list = new LinkedList();

        list.add(point);
        list.add(anotherPoint);

        String distance = "50";

        Point newPoint = new Point(100, 50);

        assertThat(DayThree.workOutNewCoordinatesOfTheWireWhenGoingDown(1, list, distance)).isEqualTo(newPoint);
    }

    @Test
    void canAddNewPointToAList() {
        LinkedList list = new LinkedList();
        Point point = new Point(0, 10);
        list.add(point);
        Point newPoint = new Point(75, 10);
        list.add(newPoint);

        DayThree.addsNewPointToList(list, newPoint);

        assertThat(list).contains(newPoint);
    }

    private static class Data {

        private String firstWireDirections;
        private String secondWireDirections;
        private int distance;

        public Data(final String firstWireDirections, final String secondWireDirections, final int distance) {

            this.firstWireDirections = firstWireDirections;
            this.secondWireDirections = secondWireDirections;
            this.distance = distance;
        }
    }
}
