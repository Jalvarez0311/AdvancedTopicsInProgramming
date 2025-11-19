package Alvarez_ProgrammingAssignment02.SolarSystem;
/** 
 * This class defines the Moon object of the virtual solar system model
 * @author J. Alvarez
 * 2588
 * Moon.java
 * 2/21/2025
 */
import Alvarez_ProgrammingAssignment02.Exceptions.DuplicateCelestialBodyException;
import Alvarez_ProgrammingAssignment02.Exceptions.InvalidCelestialBodyException;

public class Moon extends CelestialBody implements IOrbit{
    private CelestialBody orbits;

    /**
     * Function is a constructor for the Moon class
     * @param name -string value to be the name of the Moon object
     * @param orbits -string value to be the object that the Moon orbits (must be a Planet)
     */
    Moon(String name, CelestialBody orbits) throws InvalidCelestialBodyException, DuplicateCelestialBodyException{
        super(name, "Moon");
        for (CelestialBody Child : orbits.getChildren()){
            if(name.equals(Child.getName())){
                throw new DuplicateCelestialBodyException("Duplicate Error: " + name + " is already in the collection");
            }
        }
        if (!orbits.getType().equals("Planet")){
            throw new InvalidCelestialBodyException("Invalid CB (" + name + "): A moon must orbit a planet");
        }
        this.orbits = orbits;
    }

    /**
     * Function is a getter function that retrieves the object that the current Moon is orbiting (must be a Planet)
     */
    @Override
    public void getOrbit() {
        System.out.println(getName() + " is orbiting the " + orbits.getType() + " " + orbits.getName());
    }
}
