public class Path
{
    public Integer from =null;
    public Integer to =null;
    public int[] track;
    public  int offset;

    public Path(int[] track, int trackOffSet)
    {
        this.offset =trackOffSet;
        this.track=track;
    }

    public void setPoint(int value)
    {
        if (from ==null)
            from =value;
        else if (to ==null)
            to =value;
        else
            throw  new UnsupportedOperationException("Points already setted");
    }

    public  boolean isPathFind(){return  from !=null && to !=null && track!=null;}
}
