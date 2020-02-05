import java.awt.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class DayThree {

    public static void main(String[] args) {
        distanceCalculation("R75, D30");
//                "R83, U83, L12, D49, R71, U7, L72, U62, R66, U55, R34, D71, R55, D58, R83");
    }

    public static boolean distanceCalculation(String directions) {
        LinkedList<Point> firstWire = new LinkedList<>();


        addPointZeroAsFirstLocationInTheList(firstWire);
        String[] split = canSplitTheListIntoIndividualInstructions(directions);

        int elementToGet = 0;
        for (String s : split) {
            String direction = splitIndividualInstructionIntoDirection(s);
            String distance = splitIndividualInstructionIntoDistance(s);

            Point pointToAdd;

            switch (direction) {
                case "R":
                    pointToAdd = workOutNewCoordinatesOfTheWireWhenGoingRight(elementToGet, firstWire, distance);
                    addsNewPointToList(firstWire, pointToAdd);
                    break;
                case "L":
                    pointToAdd = workOutNewCoordinatesOfTheWireWhenGoingLeft(elementToGet, firstWire, distance);
                    addsNewPointToList(firstWire, pointToAdd);
                    break;
                case "U":
                    pointToAdd = workOutNewCoordinatesOfTheWireWhenGoingUp(elementToGet, firstWire, distance);
                    addsNewPointToList(firstWire, pointToAdd);
                    break;
                case "D":
                    pointToAdd = workOutNewCoordinatesOfTheWireWhenGoingDown(elementToGet, firstWire, distance);
                    addsNewPointToList(firstWire,pointToAdd);
            }
            elementToGet++;
            System.out.println("Element to Get: " + elementToGet);

            System.out.println("The First Wire List: " + Arrays.toString(firstWire.toArray()));

        }
//
//        System.out.println("First Wire: " + firstWire);

        return true;

    }

    private static void printOutNewDirectionsMap(HashMap<String, String> newDirections) {
        Iterator map = newDirections.entrySet().iterator();
        while (map.hasNext()) {
            Map.Entry pair = (Map.Entry) map.next();
            System.out.println("Key: " + pair.getKey() + " Value: " + pair.getValue());
            map.remove();
        }
    }

    public static LinkedList<Point> addPointZeroAsFirstLocationInTheList(LinkedList<Point> firstWire) {
        Point firstLocation = new Point(0, 0);
        firstWire.add(firstLocation);
        System.out.println("First Wire: " + firstWire);
        return firstWire;
    }

    public static String[] canSplitTheListIntoIndividualInstructions(String directions) {
        String[] split = directions.split(", ");
        return split;
    }

    public static String splitIndividualInstructionIntoDirection(String s) {
        return s.substring(0, 1);
    }

    public static String splitIndividualInstructionIntoDistance(String s) {
        return s.substring(1);
    }

    public static Point workOutNewCoordinatesOfTheWireWhenGoingRight(int elementToGet, LinkedList<Point> firstWire, String distance) {
        int currentX = (int) firstWire.get(elementToGet).getX();
        int newX = currentX + Integer.parseInt(distance);
        int newY = (int) firstWire.get(elementToGet).getY();
        Point newPoint = new Point(newX, newY);
        return newPoint;
    }

    public static Point workOutNewCoordinatesOfTheWireWhenGoingLeft(int elementToGet, LinkedList<Point> firstWire, String distance) {
        int currentX = (int) firstWire.get(elementToGet).getX();
        int newX = currentX - Integer.parseInt(distance);
        int newY = (int) firstWire.get(elementToGet).getY();
        Point newPoint = new Point(newX, newY);
        return newPoint;
    }

    public static Point workOutNewCoordinatesOfTheWireWhenGoingUp(int elementToGet, LinkedList<Point> firstWire, String distance) {
        int newX = (int) firstWire.get(elementToGet).getX();
        int currentY = (int) firstWire.get(elementToGet).getY();
        int newY = currentY + Integer.parseInt(distance);
        return new Point(newX, newY);
    }

    public static Point workOutNewCoordinatesOfTheWireWhenGoingDown(int elementToGet, LinkedList<Point> firstWire, String distance) {
        int newX = (int) firstWire.get(elementToGet).getX();
        int currentY = (int) firstWire.get(elementToGet).getY();
        int newY = currentY - Integer.parseInt(distance);
        return new Point(newX, newY);
    }

    public static void addsNewPointToList(LinkedList<Point> firstWire, Point newPoint) {
        firstWire.add(newPoint);
    }
}
//(?<=\D)(?=\d)|(?<=\d)(?=\D)
