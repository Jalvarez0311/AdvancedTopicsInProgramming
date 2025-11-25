package Alvarez_ProgrammingAssignment03.solarsystem;
import javafx.scene.paint.Color;
/** 
 * This class defines the Star object of the virtual solar system model
 * @author J. Alvarez
 * 2588
 * Star.java
 * 3/25/2025
 */

public class Star extends CelestialBody{
    private int surfaceTemp;

    /**
     * Function is a constructor for the Star class
     * @param name -string value to be the name of the planet object
     * @param surfaceTemp -integer set to be the approximate surface temperature of the star
     * @param color -Color value that is used to assign a color for the circle
     * @param radius -double value that holds the size of the circle
     */
    public Star(String name, int surfaceTemp, Color color, double radius){
        super(name, "Star", color, radius);
        this.surfaceTemp = surfaceTemp;
    }

    /**
     * Function is a getter function for the surfaceTemp variable
     */
    public int getSurfaceTemp(){
        return surfaceTemp;
    }
}
