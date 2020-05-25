/**
 * Project title: 08.09 Javadocs
 *
 * Purpose of Project: Calculate the C02 output by the number of gas used.
 *
 * @version 12/1/2019
 *
 * @author Anika Jallipalli
 *
 * *********** PMR ***********
 * (+) Understood OOP more.
 *
 * (-) Need more practice with OOP.
 * ***************************
 *
 * In the future: Practice.
 */
public class CO2FootprintV2
{
    private double myGallonsUsed, myTonsCO2, myPoundsCO2;

 /*
    Constructor for C02FootPrint.
    @param gals = gallons used
     */
    CO2FootprintV2(double gallons)
    {
        myGallonsUsed = gallons;
    }
 public void calcTonsCO2()
    {
        myTonsCO2 = (8.78 * Math.pow(10, -3)) * myGallonsUsed;
    }

  /*
    Method to get Pounds of C02
    @return double of the myPoundsC02
     */
    public void convertTonsToPounds()
    {
        myPoundsCO2 = myTonsCO2 * 2205;
    }
 /*
    Method to get Tons of C02
    @return double of myTonsC02;
     */

    public double getGallons()
    {
        return myGallonsUsed;
    }

 /*
    Method to calculate tons of C02 emitted
    myTonsC02 multiplied by the gallons used and the formula to calculate
     */
    public double getTonsCO2()
    {
        return myTonsCO2;
    }

/*
    Method to convert Tons to Pounds
    myPoundsC02 is equal to Tons multiplied by 2204.6 (Amount of pounds in a ton)
     */
    public double getPoundsCO2()
    {
        return myPoundsCO2;
    }
}

