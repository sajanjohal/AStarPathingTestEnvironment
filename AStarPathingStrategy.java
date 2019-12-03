import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        return path;
    }
}
