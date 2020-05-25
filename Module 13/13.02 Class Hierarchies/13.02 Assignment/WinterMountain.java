/**
 * Winter Mountain terrain.
 * 
 * @author Anika Jallipalli
 * @version 1/29/2020
 */
public class WinterMountain extends Mountain
{
    private double temperature;
    public WinterMountain(int l, int w, int m, double temp)
    {
        super(l, w, m);
        temperature = temp;
    }
    
    public double getTemp()
    {
        return temperature;
    }
}