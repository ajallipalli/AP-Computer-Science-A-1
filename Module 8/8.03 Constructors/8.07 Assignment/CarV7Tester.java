




/**
 * Project title: 08.07 
 *
 * Purpose of Project: Calculate gas used.
 *
 * @version 11/26/2019
 *
 * @author Anika Jallipalli
 */
public class CarV7Tester
{
    public static void main(String[] args)
    {
       

        //CarV7 car1 = new CarV7(name, endMiles, startMiles, gallonsUsed, pricePerGallon);
        CarV7 carV7 = new CarV7();
        CarV7.OptCar car1 = carV7.new OptCar("Tesla SP90D", 2000, 8450, 222, 3.5);
        CarV7.OptCar car2 = carV7.new OptCar("BMW X8", 4000, 10450, 280, 3.5);
        CarV7.OptCar car3 = carV7.new OptCar("Toyota Prius", 6000, 12450, 320, 3.5);
        
        //Stats for cars
        int dist1 = CarV7.calcDistance(car1.milesAtStart,car1.milesWhenEnd), dist2 = CarV7.calcDistance(car2.milesAtStart,car2.milesWhenEnd), dist3 = CarV7.calcDistance(car3.milesAtStart,car3.milesWhenEnd);
        
        double mpg1 = CarV7.calcMPG(dist1,car1.gallonsUsed), mpg2 = CarV7.calcMPG(dist2,car2.gallonsUsed), mpg3 = CarV7.calcMPG(dist3,car3.gallonsUsed);
        
        double totalCost1 = CarV7.calcCost(car1.pricePGallon,car1.gallonsUsed), totalCost2 = CarV7.calcCost(car2.pricePGallon,car2.gallonsUsed), totalCost3 = CarV7.calcCost(car3.pricePGallon,car3.gallonsUsed);
        
        double totalGPM1 = CarV7.calcGPM(dist1,car1.gallonsUsed), totalGPM2 = CarV7.calcGPM(dist2,car2.gallonsUsed), totalGPM3 = CarV7.calcGPM(dist3,car3.gallonsUsed);
        
        
        
        

        System.out.printf("%20s%20s%20s%20s%20s%20s%20s%20s%20s\n","Type of Car","Start Miles","End Miles","Distance","Gallons","Price","Cost","Miles/Gal","Gal/Mile");
        System.out.print("=========================================================================================================================================================================================\n");
        System.out.printf("%20s%20d%20d%20d%20.1f%20.1f%20.1f%20.1f%20.3f\n",car1.name, car1.milesAtStart, car1.milesWhenEnd, dist1, car1.gallonsUsed, car1.pricePGallon, totalCost1, mpg1 ,totalGPM1);
        System.out.printf("%20s%20d%20d%20d%20.1f%20.1f%20.1f%20.1f%20.3f\n",car2.name, car2.milesAtStart, car2.milesWhenEnd, dist2, car2.gallonsUsed, car2.pricePGallon, totalCost2, mpg2, totalGPM2);
        System.out.printf("%20s%20d%20d%20d%20.1f%20.1f%20.1f%20.1f%20.3f\n",car3.name, car3.milesAtStart, car3.milesWhenEnd, dist3, car3.gallonsUsed, car3.pricePGallon, totalCost3, mpg3, totalGPM3);
    }
    
}