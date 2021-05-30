import org.junit.Assert;
import org.junit.Test;

public class LongTest
{
    @Test
    public  void LongTest()
    {
        var size = 7500;
        char[][] data = new char[size][size];

        for (var i=0; i<size; i++)
        {
            var line=new char[size];

            for (var j=0; j<line.length;j++)
                line[j]='.';
            data[i]=(line);

            line = new char[size];

            i++;

            for (var j=0; j<line.length-1;j++)
                line[j]='.';//#
            line[line.length-1]='.';
            data[i]=line;
        }

        data[7000][7000]='@';
        data[size-1][size-1]='X';

        var startedTime = System.currentTimeMillis();

        var actual = new BFSRouteFinder().findRoute(data);
        var endTime = System.currentTimeMillis();

        System.out.println("time "+(endTime-startedTime));
        Assert.assertNotNull(actual);
    }
}
