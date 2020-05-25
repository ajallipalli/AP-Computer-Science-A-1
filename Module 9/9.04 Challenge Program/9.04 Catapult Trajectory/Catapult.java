/**
 * Project title: 09.04 Challenge Program
 *
 * Purpose of Project: Calculates the trajectory of a projectile based on launch angles and launch velocities.
 *
 *
 * @version 12/12/2019
 *
 * @author Anika Jallipalli
 */

public class Catapult {

    private double velocity, degrees, distance;

    public Catapult(double v, double deg) {
        velocity = v;
        degrees = deg;
    }

    public double getVelocity(){
        return velocity;
    }

    public double getDegrees(){
        return degrees;
    }

    public double getDistance(){
        return distance;
    }

    public void calcDistance(){
        distance = (Math.pow(velocity, 2) * Math.sin( 2 * Math.toRadians(degrees)) / 9.8);
    }

}