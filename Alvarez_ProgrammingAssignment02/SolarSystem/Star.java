package Alvarez_ProgrammingAssignment02.SolarSystem;
/** 
 * This class defines the Star object of the virtual solar system model
 * @author J. Alvarez
 * 2588
 * Star.java
 * 2/21/2025
 */
import Alvarez_ProgrammingAssignment02.Exceptions.InvalidCelestialBodyException;

public class Star extends CelestialBody{
    private int surfaceTemp;

    /**
     * Function is a constructor for the Star class
     * @param name -string value to be the name of the planet object
     * @param surfaceTemp -integer set to be the approximate surface temperature of the star
     */
    Star(String name, int surfaceTemp) throws InvalidCelestialBodyException{
        super(name, "Star");
        this.surfaceTemp = surfaceTemp;
        if (name == null || name.isEmpty()) {
            throw new InvalidCelestialBodyException("Invalid CB (" + name + "): Star name cannot be null or empty.");
        }
    }

    /**
     * Function is a getter function for the surfaceTemp variable
     */
    public int getSurfaceTemp() {
        return surfaceTemp;
    }
}
