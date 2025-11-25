package Alvarez_ProgrammingAssignment03.solarsystem;

/** 
 * This class defines the interface for the getOrbit function to be implemented by other classes
 * @author J. Alvarez
 * 2588
 * IOrbit.java
 * 3/25/2025
 */

public interface IOrbit {
    /**
     * Function is a getter function that serves as the Interface for other classes to implement
     */
    public CelestialBody getOrbit();
    /**
     * Function is another getter function serving to do the same as the first 
     */
    public void getOrbitInformation();
}