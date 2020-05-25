/**
 * Project title: 08.08 Arrays of Objects
 *
 * Purpose of Project: Calculate gas used.
 *
 * @version 11/26/2019
 *
 * @author Anika Jallipalli
 */
public class AnnualFuelUse {

    private int fillup, days, startMiles, endMiles, distance;
    private double gallonsUsed, mpg, price, cost;

    AnnualFuelUse(int fill, int day, int startMi, int endMi, double galUsed, double pricePerGal) {
        fillup = fill;
        days = day;
        startMiles = startMi;
        endMiles = endMi;
        gallonsUsed = galUsed;
        price = pricePerGal;
    }

    public int getFillup() {
        return fillup;
    }

    public int getDays() {
        return days;
    }

    public int getStartMiles() {
        return startMiles;
    }

    public int getEndMiles() {
        return endMiles;
    }

    public double getGalsUsed() {
        return gallonsUsed;
    }

    public double getPrice() {
        return price;
    }

    public int calcDistance() {
        distance = endMiles - startMiles;
        return distance;
    }

    public double calcMPG() {
        mpg = ((double)distance) / gallonsUsed;
        return mpg;
    }

    public double calcCost() {
        cost = gallonsUsed * price;
        return cost;
    }

}