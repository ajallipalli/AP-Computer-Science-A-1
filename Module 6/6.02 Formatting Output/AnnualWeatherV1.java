/**
 * Annual Weather description:
 * 
 * @author (enter your name)
 * @version (enter today's date)
 *
 */
import java.util.Scanner;
public class AnnualWeatherV1
{
    public static void main (String [ ] args)
    {

        //Declare and initialize variables
        Scanner in = new Scanner(System.in);
        String city = "";
        String state = "";
  
        String [] month = {"Jan", "Feb" };
        double [] temperature ={2.0, 4.5};     //initialize with Fahrenheit values
        double [] precipitation ={53, 55};      //initialize with inch values
    
        String tempLabel = "F";    //initialize to F
        String precipLabel = "in."; //initialize to in
    
    
        //Processing - calculate average temperature and total precipitation
        for( int index = 0; index < temperature.length; index++)
        {
  
        }
    
    
        //Output: display table of weather data including average and total
        System.out.println();
        System.out.println("           Weather Data");
        System.out.println("      Location: " + city +", " + state);
        System.out.println("Month     Temperature (" +  tempLabel + ")     Precipitation (" + precipLabel + ")");
        System.out.println();
        System.out.println("***************************************************");
        for( int index = 0; index < temperature.length; index++)
        {
  
        }
        System.out.println("Average: " + "    Total: ");

    }//end main
}//end class
