import java.awt.*;
import java.util.*;

public class BFSRouteFinder implements RouteFinder
{
    private int rowCount;
    private  int tableCount;

    private Point[] directions =
    {
        new Point(1, 0), new Point(-1, 0),
        new Point(0, 1), new Point(0, -1)
    };


    public  char[][] findRoute(char[][] map)
    {
        tableCount = map[0].length;
        rowCount = map.length;

        BitSet visited = new BitSet(rowCount*tableCount);
        for (var i=0; i< map.length; i++)
        {
            for (var j = 0; j < map[i].length; j++)
            {
                if (map[i][j]=='@' || map[i][j]=='X')
                {
                    Path path = startBFS(map, i*tableCount+j, visited);
                    if (path.isPathFind())
                        return  getPrintedPath(map, path);
                    else
                        return null;
                }
                visited.set(i*tableCount+j, true);

            }
        }

        return  null;
    }

    private Path startBFS(char[][] map, int start, BitSet visited)
    {
        int trackOffset = visited.cardinality();
        int[] track = new int[rowCount*tableCount- trackOffset];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Path result= new Path(track, trackOffset);

        deque.add(start);
        visited.set(start, true);

        while (!deque.isEmpty())
        {
            int toOpen = deque.pop();
            visited.set(toOpen, true);

            char symbol = map[toOpen / tableCount][toOpen % tableCount];
            if (symbol == '@' || symbol=='X')
                result.setPoint(toOpen);
            if (result.isPathFind())
                return result;

            for (var next: getNeighbors(toOpen, map,  visited))
            {
                deque.offer(next);
                track[next-trackOffset]=toOpen;
                visited.set(next, true);
            }

        }

        return result;
    }


    private ArrayList<Integer> getNeighbors(Integer toOpen, char[][] map, BitSet visited)
    {
        ArrayList<Integer> neighbors = new ArrayList<>(4);
        for(Point dir: directions)
        {
            Point toOpenP = new Point(toOpen%tableCount, toOpen/tableCount);
            int newX = toOpenP.x+dir.x;
            int newY= toOpenP.y+dir.y;

            boolean pointIsCorrect = newY>=0 && newX>=0 && newY<rowCount && newX<tableCount;
            boolean isNotWall = pointIsCorrect && map[newY][newX]!='#';
            boolean isNotVisited =pointIsCorrect && !visited.get(newY * tableCount + newX);

            if (isNotWall && isNotVisited)
                neighbors.add(newY * tableCount + newX);
        }
        return  neighbors;
    }

    private  char[][] getPrintedPath(char[][] map, Path path)
    {
        int to  =path.to;
        to = path.track[to-path.offset];

        while (to!=path.from)
        {
            map[to/tableCount][to%tableCount]='+';
            to = path.track[to-path.offset];
        }

        return  map;
    }
}