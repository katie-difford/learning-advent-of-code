import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

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

//
//
        for (String s : split) {
            String direction = splitIndividualInstructionIntoDirection(s);
            String distance = splitIndividualInstructionIntoDistance(s);

            Point pointToAdd;
            if (direction.equals("R")) {
                pointToAdd = workOutNewCoordinatesOfTheWireWhenGoingRight(firstWire, distance);
                addsNewPointToList(firstWire, pointToAdd);
            } else if (direction.equals("R")) {
                pointToAdd = workOutNewCoordinatesOfTheWireWhenGoingLeft(firstWire, distance);
                addsNewPointToList(firstWire, pointToAdd);
            }

//
//            int pointToGet = 0;
//            Point previousPoint = firstWire.get(pointToGet);
//            double x = previousPoint.getX();
//            double y = previousPoint.getY();

//            if (direction.equals("R")) {
//                //this is where it breaks.
//                int xDirection = parseInt(valueOf(x)) + parseInt(distanceToMove);
//                int yDirection = parseInt(valueOf(y));
//                firstWire.add(new Point(xDirection, yDirection));
//                pointToGet++;
//            } else if (direction.equals("L")) {
//                int xDirection = parseInt(valueOf(x)) - parseInt(distanceToMove);
//                int yDirection = parseInt(valueOf(y));
//                firstWire.add(new Point(xDirection, yDirection));
//                pointToGet++;
//            } else if (direction.equals("U")) {
//                int xDirection = parseInt(valueOf(x));
//                int yDirection = parseInt(valueOf(y)) + parseInt(distanceToMove);
//                firstWire.add(new Point(xDirection, yDirection));
//                pointToGet++;
//            } else if (direction.equals("D")) {
//                int xDirection = parseInt(valueOf(x));
//                int yDirection = parseInt(valueOf(y)) - parseInt(distanceToMove);
//                firstWire.add(new Point(xDirection, yDirection));
//                pointToGet++;
//            }

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

    public static Point workOutNewCoordinatesOfTheWireWhenGoingRight(LinkedList<Point> firstWire, String distance) {
        int currentX = (int) firstWire.get(0).getX();
        int newX = currentX + Integer.parseInt(distance);
        int newY = (int) firstWire.get(0).getY();
        Point newPoint = new Point(newX, newY);
        return newPoint;
    }

    public static Point workOutNewCoordinatesOfTheWireWhenGoingLeft(LinkedList<Point> firstWire, String distance) {
        int currentX = (int) firstWire.get(0).getX();
        int newX = currentX - Integer.parseInt(distance);
        int newY = (int) firstWire.get(0).getY();
        Point newPoint = new Point(newX, newY);
        return newPoint;
    }

    public static void addsNewPointToList(LinkedList<Point> firstWire, Point newPoint) {
        firstWire.add(newPoint);
    }
}
//(?<=\D)(?=\d)|(?<=\d)(?=\D)
