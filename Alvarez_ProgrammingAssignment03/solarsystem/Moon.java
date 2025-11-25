package Alvarez_ProgrammingAssignment03.solarsystem;
/** 
 * This class defines the Moon object of the virtual solar system model
 * @author J. Alvarez
 * 2588
 * Moon.java
 * 3/25/2025
 */
import Alvarez_ProgrammingAssignment02.Exceptions.InvalidCelestialBodyException;
import javafx.scene.paint.Color;

public class Moon extends CelestialBody implements IOrbit{
    private CelestialBody orbits;

    /**
     * Function is a constructor for the Moon class
     * @param name -string value to be the name of the Moon object
     * @param orbits -string value to be the object that the Moon orbits (must be a Planet)
     * @param color -Color value that is used to assign a color for the circle
     * @param radius -double value that holds the size of the circle
     */
    public Moon(String name, CelestialBody orbits, Color color, double radius) throws InvalidCelestialBodyException{
        super(name, "Moon", color, radius);
        if ("Planet".equals(orbits.getType())) {
            this.orbits = orbits;
        } else {
            throw new InvalidCelestialBodyException("A moon must orbit a planet.");
        }
    }

    /**
     * Function is a getter function that retrieves the object that the current Moon is orbiting (must be a Planet)
     */
    @Override
    public CelestialBody getOrbit() {
        return orbits;
    }

    /**
     * Function is a getter function that retrieves information of the orbited body
     */
    @Override
    public void getOrbitInformation() {
        System.out.println(getName() + " is orbiting the " + orbits.getType() + " " + orbits.getName());
    }
}
