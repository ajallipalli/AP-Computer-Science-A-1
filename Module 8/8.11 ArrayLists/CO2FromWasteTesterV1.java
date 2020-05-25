/**
 * @purpose:
 *
 * @author (enter your name)
 * @version (enter today's date)
 *
 */
import java.util.ArrayList;

public class CO2FromWasteTesterV1
{
   public static void main(String[] args)
   {
       ArrayList<CO2FromWasteV1> households = new ArrayList<CO2FromWasteV1>();
           // add households to the ArrayList

       for(CO2FromWasteV1 dataRecord : households)
       {
           // invoke methods
       }

       System.out.println("|       |        |                                         |             Pounds of CO2             |");
       System.out.println("|       |        |       Household Waste Recycled          |   Total    |             |     Net    |");
       System.out.println("| Index | People |  Paper   |  Plastic |  Glass  |  Cans   |  Emission  |  Reduction  |  Emission  |");
       System.out.println("|-------|--------|----------|----------|---------|---------|------------|-------------|------------|");

       CO2FromWasteV1 dataRecord;

       for(int index = 0; index < households.size(); index ++)
       {
           // print each household's data

       }
   }
}

