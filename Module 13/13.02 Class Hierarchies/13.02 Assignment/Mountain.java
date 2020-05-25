/**
 * Mountainous terrain.
 * 
 * @author Anika Jallipalli
 * @version 1/29/2020
 */
public class Mountain extends Terrain
{
    private int mountains;
    public Mountain(int l, int w, int m)
    {
        super(l, w);
        mountains = m;
    }
    
    public int getMountains()
    {
        return mountains;
    }
}