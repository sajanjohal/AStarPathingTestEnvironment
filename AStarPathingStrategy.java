import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.HashMap;
import java.lang.Math;

class AStarPathingStrategy
        implements PathingStrategy
{


    public List<Point> computePath(Point start, Point end,
                                   Predicate<Point> canPassThrough,
                                   BiPredicate<Point, Point> withinReach,
                                   Function<Point, Stream<Point>> potentialNeighbors)
    {
        //List of points that gets returned
        List<Point> path = new LinkedList<Point>();

        //Open list that holds all adjacent cells that are needed to be processed
        PriorityQueue<Cell> openList = new PriorityQueue<Cell>(Comparator.comparing(Cell::getF));

        //Closed list that holds all cells that have been visited
        HashMap<Point, Cell> closedList = new HashMap<>();

        //Turn start point into Cell object and add to open list to start things off
        Cell origin = new Cell(start, 0, calcH(start, end));
        openList.add(origin);

        while (openList.size() > 0) {

            //Get node with least f value in openList (should be top b/c using PriorityQueue)
            Cell current = openList.remove();
            openList.clear();

            //Use potentialNeighbor function to get list of potential neighbors
            //Clean up potentialNeighbor list by filtering out points that are blocked or are in closed list
            List<Point> cleanAdjPoints = potentialNeighbors.apply(current.getPoint())
                    .filter(canPassThrough)
                    .filter(p -> !closedList.containsKey(p))
                    .collect(Collectors.toList());

            //add each point in cleaned up list as a Cell to openList
            for (int i = 0; i < cleanAdjPoints.size(); i ++) {

                Point neighbor = cleanAdjPoints.get(i);
                openList.add(new Cell(neighbor, current.getG() + 1, calcH(neighbor, end)));

            }


            //add current to closed list
            closedList.put(current.getPoint(), current);
            path.add(0, current.getPoint());

        }

        return path;

    }

    private int calcH(Point start, Point end) {
        return (Math.abs(start.x - end.x) + Math.abs(start.y - end.y));
    }

}
