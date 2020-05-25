/**
 * Forest terrain.
 * 
 * @author Anika Jallipalli
 * @version 1/29/2020
 */

public class Forest extends Terrain
{
    private int trees;
    public Forest(int l, int w, int t)
    {
        super(l, w);
        trees = t;
    }
    
    public int getTrees()
    {
        return trees;
    }
}