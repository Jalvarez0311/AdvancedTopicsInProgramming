package Alvarez_ProgrammingAssignment03.solarsystem;
/** 
 * This class defines the Planet object of the virtual solar system model
 * @author J. Alvarez
 * 2588
 * Planet.java
 * 3/25/2025
 */
import Alvarez_ProgrammingAssignment02.Exceptions.InvalidCelestialBodyException;
import javafx.scene.paint.Color;

public class Planet extends CelestialBody implements IOrbit{
    private CelestialBody orbits;

    /**
     * Function is a constructor for the Planet class
     * @param name -string value to be the name of the Planet object
     * @param orbits -string value to be the object that the Planet orbits (must be a Star)
     * @param color -Color value that is used to assign a color for the circle
     * @param radius -double value that holds the size of the circle
     */
    public Planet(String name, CelestialBody orbits, Color color, double radius) throws InvalidCelestialBodyException{
        super(name, "Planet", color, radius);
        if("Star".equals(orbits.getType())){
            this.orbits = orbits;
        } else{
            throw new InvalidCelestialBodyException("A planet must orbit a star");
        }
    }

    /**
     * Function is a getter function that retrieves the object that the current Planet is orbiting (must be a Star)
     */
    @Override
    public CelestialBody getOrbit() {
        return orbits;
    }

    /**
     * Function is a getter function that retrieves the information of the orbited object
     */
    @Override
    public void getOrbitInformation(){
        System.out.println(getName() + " is orbiting the " + orbits.getType() + " " + orbits.getName());
    } 
}
