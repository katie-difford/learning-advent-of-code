import java.awt.*;
import java.util.*;
import java.util.stream.Stream;

public class DayThree {

    public static void main(String[] args) {
        DayThree dayThree = new DayThree();

        int distance = dayThree.distanceCalculationForWire("R75, D30, R83, U83, L12, D49, R71, U7, L72", "U62, R66, U55, R34, D71, R55, D58, R83");
        System.out.println("Distance: " + distance);
    }

    public int distanceCalculationForWire(String firstWireDirections, String secondWireDirections) {
        LinkedList<Point> firstWire = new LinkedList<>();
        LinkedList<Point> secondWire = new LinkedList<>();

        addPointZeroAsFirstLocationInTheList(firstWire);
        String[] splitFirstWire = canSplitTheListIntoIndividualInstructions(firstWireDirections);
        LinkedList<Point> firstWirePoints = createTheWire(firstWire, splitFirstWire);

        addPointZeroAsFirstLocationInTheList(secondWire);
        String[] splitSecondWire = canSplitTheListIntoIndividualInstructions(secondWireDirections);
        LinkedList<Point> secondWirePoints = createTheWire(secondWire, splitSecondWire);

        LinkedList<Point> crossingPoints = new LinkedList<>();

        //Replace with stream to iterate between two lists and compare the values, if they are the same then add them to the list, if they are not the same, then ignore.
//        for (int i = 0; i < firstWirePoints.size(); i++) {
//            for (int j = 0; j < secondWirePoints.size(); j++) {
//                if (firstWirePoints.get(i).equals(secondWirePoints.get(j))) {
//                    crossingPoints.add(secondWirePoints.get(j));
//                }
//            }
//        }

        System.out.println("Crossing Points: " + Arrays.toString(crossingPoints.toArray()));

        return 0;
    }

    private LinkedList<Point> createTheWire(LinkedList<Point> wire, String[] splitFirstWire) {
        int elementToGet = 0;
        for (String s : splitFirstWire) {
            String direction = splitIndividualInstructionIntoDirection(s);
            String distance = splitIndividualInstructionIntoDistance(s);

            Point pointToAdd;

            switch (direction) {
                case "R":
                    pointToAdd = workOutNewCoordinatesOfTheWireWhenGoingRight(elementToGet, wire, distance);
                    addsNewPointToList(wire, pointToAdd);
                    break;
                case "L":
                    pointToAdd = workOutNewCoordinatesOfTheWireWhenGoingLeft(elementToGet, wire, distance);
                    addsNewPointToList(wire, pointToAdd);
                    break;
                case "U":
                    pointToAdd = workOutNewCoordinatesOfTheWireWhenGoingUp(elementToGet, wire, distance);
                    addsNewPointToList(wire, pointToAdd);
                    break;
                case "D":
                    pointToAdd = workOutNewCoordinatesOfTheWireWhenGoingDown(elementToGet, wire, distance);
                    addsNewPointToList(wire, pointToAdd);
            }
            elementToGet++;
        }

        return wire;
    }

    public LinkedList<Point> addPointZeroAsFirstLocationInTheList(LinkedList<Point> firstWire) {
        Point firstLocation = new Point(0, 0);
        firstWire.add(firstLocation);
        System.out.println("First Wire: " + firstWire);
        return firstWire;
    }

    public static String[] canSplitTheListIntoIndividualInstructions(String directions) {
        String[] split = directions.split(", ");
        return split;
    }

    public String splitIndividualInstructionIntoDirection(String s) {
        return s.substring(0, 1);
    }

    public String splitIndividualInstructionIntoDistance(String s) {
        return s.substring(1);
    }

    public Point workOutNewCoordinatesOfTheWireWhenGoingRight(int elementToGet, LinkedList<Point> firstWire, String distance) {
        int currentX = (int) firstWire.get(elementToGet).getX();
        int newX = currentX + Integer.parseInt(distance);
        int newY = (int) firstWire.get(elementToGet).getY();
        Point newPoint = new Point(newX, newY);
        return newPoint;
    }

    public Point workOutNewCoordinatesOfTheWireWhenGoingLeft(int elementToGet, LinkedList<Point> firstWire, String distance) {
        int currentX = (int) firstWire.get(elementToGet).getX();
        int newX = currentX - Integer.parseInt(distance);
        int newY = (int) firstWire.get(elementToGet).getY();
        Point newPoint = new Point(newX, newY);
        return newPoint;
    }

    public Point workOutNewCoordinatesOfTheWireWhenGoingUp(int elementToGet, LinkedList<Point> firstWire, String distance) {
        int newX = (int) firstWire.get(elementToGet).getX();
        int currentY = (int) firstWire.get(elementToGet).getY();
        int newY = currentY + Integer.parseInt(distance);
        return new Point(newX, newY);
    }

    public Point workOutNewCoordinatesOfTheWireWhenGoingDown(int elementToGet, LinkedList<Point> firstWire, String distance) {
        int newX = (int) firstWire.get(elementToGet).getX();
        int currentY = (int) firstWire.get(elementToGet).getY();
        int newY = currentY - Integer.parseInt(distance);
        return new Point(newX, newY);
    }

    public void addsNewPointToList(LinkedList<Point> firstWire, Point newPoint) {
        firstWire.add(newPoint);
    }
}
