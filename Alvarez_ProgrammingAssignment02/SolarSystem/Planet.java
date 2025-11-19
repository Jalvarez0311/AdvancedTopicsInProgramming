package Alvarez_ProgrammingAssignment02.SolarSystem;
/** 
 * This class defines the Planet object of the virtual solar system model
 * @author J. Alvarez
 * 2588
 * Planet.java
 * 2/21/2025
 */
import Alvarez_ProgrammingAssignment02.Exceptions.DuplicateCelestialBodyException;
import Alvarez_ProgrammingAssignment02.Exceptions.InvalidCelestialBodyException;

public class Planet extends CelestialBody implements IOrbit{
    private CelestialBody orbits;

    /**
     * Function is a constructor for the Planet class
     * @param name -string value to be the name of the Planet object
     * @param orbits -string value to be the object that the Planet orbits (must be a Star)
     */
    Planet(String name, CelestialBody orbits) throws InvalidCelestialBodyException, DuplicateCelestialBodyException{
        super(name, "Planet");
        for (CelestialBody Child : orbits.getChildren()){
            if(name.equals(Child.getName())){
                throw new DuplicateCelestialBodyException("Duplicate Error: " + name + " is already in the collection");
            }
        }
        if (!orbits.getType().equals("Star")){
            throw new InvalidCelestialBodyException("Invalid CB (" + name + "): A planet must orbit a star");
        }
        this.orbits = orbits;
    }

    /**
     * Function is a getter function that retrieves the object that the current Planet is orbiting (must be a Star)
     */
    @Override
    public void getOrbit() {
        System.out.println(getName() + " is orbiting the " + orbits.getType() + " " + orbits.getName());
    }
}
