public class GraphHasEdge 
{
    public boolean hasEdge(int v, int w) 
    {
        for (int neighbor : adjacent(v))
        {
            if (neighbor == w)
            {
                return true;
            }
        }
        return false;
    }
}
