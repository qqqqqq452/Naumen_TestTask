import org.junit.Assert;
import org.junit.Test;

public class SimpleTests
{
    BFSRouteFinder walker= new BFSRouteFinder();

    @Test
    public  void SimpleTests()
    {
        char[][][] data =
        {
                {
                        {'.', '.', '.', '.', '#', '.'},
                        {'.', '.', '.', '.', '#', '.'},
                        {'.', '.', '.', '.', '#', '.'},
                        {'.', '.', '.', '#', '@', '.'},
                        {'.', '.', 'X', '#', '#', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                },
                {
                        {'X', '.', '.', '#', '.', '.'},
                        {'.', '#', '.', '#', '.', '.'},
                        {'.', '#', '.', '#', '.', '.'},
                        {'.', '.', '.', '#', '.', '.'},
                        {'.', '#', '#', '#', '.', '.'},
                        {'.', '.', '.', '.', '.', '@'},
                },
                {
                        {'@', '.', '.', '#', '.', '.'},
                        {'.', '#', '.', '#', '.', '.'},
                        {'#', '#', '.', '#', '.', '.'},
                        {'.', '.', '.', '#', '.', '.'},
                        {'.', '#', '#', '#', '.', '.'},
                        {'.', '.', '.', '.', '.', 'X'},
                },
                {
                        {'@', '#', '.', '.', '.', '.'},
                        {'.', '#', '.', '#', '.', '.'},
                        {'.', '#', '.', '#', '.', '.'},
                        {'.', '#', '.', '#', '.', '.'},
                        {'.', '#', '#', '#', '.', '.'},
                        {'.', '.', '.', '.', '.', 'X'},
                },
                {
                        {'@', '#', '.', '.', '.', '.'},
                        {'.', '#', '.', '#', '.', '.'},
                        {'.', '#', '.', '#', '#', '.'},
                        {'.', '#', 'X', '#', '.', '.'},
                        {'.', '#', '#', '#', '#', '.'},
                        {'.', '.', '.', '.', '.', '.'},
                },

        };
        int[] expected = {6,9,13,9,20};

        for (var i=0; i< data.length; i++)
        {
            var actual = walker.findRoute(data[i]);
            Print(actual);
            Assert.assertTrue(check(actual, expected[i]));
        }

    }

    public  boolean check(char[][] res, int expected)
    {
        var counter = 0;

        for (char[] row:res)
            for (char symbol:row)
                if (symbol=='+')
                    counter++;

        return  expected==counter;
    }

    public  void Print(char[][] map)
    {
        for (char[] row:map)
            System.out.println(new String(row));
        System.out.println();
    }
}
