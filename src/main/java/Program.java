public  class Program
{

    public static void main(String[] args)
    {
        char[][] map = new char[][]
        {
                {'@'},
                {'X'}
        };
        var res = new BFSRouteFinder().findRoute(map);

        for (char[] line:res)
            System.out.println(String.valueOf(line));
    }
}
