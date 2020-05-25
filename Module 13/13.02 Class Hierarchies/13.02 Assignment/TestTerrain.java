/**
 * 
 * Tests all of the terrains and their specs.
 * @author Anika Jallipalli
 * @version 1/29/2020
 */

public class TestTerrain
{
    public static void main(String[] args)
    {
        Terrain t1 = new Terrain(50, 50);
        Forest f1 = new Forest(100, 200, 100);
        Mountain m1 = new Mountain(300, 400, 25);
        WinterMountain wm1 = new WinterMountain(500, 600, 15, 10.0);
        System.out.println(t1.getTerrainSize());
        System.out.println("Forest " + f1.getTerrainSize() + " and has " + f1.getTrees() + " trees.");
        System.out.println("Mountain " + m1.getTerrainSize() + " and has " + m1.getMountains() + " mountains.");
        System.out.println("Forest " + wm1.getTerrainSize() + " and has temperature " +wm1.getTemp()+ " and " + wm1.getMountains() + " mountains.");
    }
}