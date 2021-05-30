import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class NoSolution
{
    public BFSRouteFinder walker = new BFSRouteFinder();

    @Test
    public  void  NoSolution()
    {
        char[][][] data =
                {
                        {
                            {'@', '.', '.'},
                            {'.', '.', '#'},
                            {'.', '#', 'X'},
                        },
                        {
                            {'@', '.', '.'},
                            {'#','#','#'},
                            {'.', '.', 'X'},
                        },
                        {
                            {'@', '#', '#'},
                            {'#', '#', '#'},
                            {'#', '#', 'X'},
                        },
                        {
                            {'#', '#', '#'},
                            {'#', '@', '#'},
                            {'#', '#', 'X'},
                        },
                        {
                            {'@', '#'},
                            {'#', 'X'},
                            {'#' ,'#'},
                        },
                        {
                            {'@', '.', '.'},
                            {'.', '#', '#'},
                            {'.', '#', 'X'},
                        }

                };

        for (var map:data)
            Assert.assertNull(walker.findRoute(map));
    }
}
