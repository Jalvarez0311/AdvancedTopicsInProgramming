package Alvarez_ProgrammingAssignment02.SolarSystem;
import Alvarez_ProgrammingAssignment02.Exceptions.DuplicateCelestialBodyException;
import java.util.ArrayList;
/** 
 * This class defines the Celestial Body object of the virtual solar system model
 * @author J. Alvarez
 * 2588
 * CelestialBody.java
 * 2/21/2025
 */
public class CelestialBody {
    private String name;
    private String type;
    private ArrayList<CelestialBody> Children;

    /**
     * Function is a constructor for the CelestialBody class
     * @param name -string value to be the name of the Celestial Body object
     * @param type -string value to define the type of Celestial Body the object will be
     */
    CelestialBody(String name, String type){
        this.name = name;
        this.type = type;
        this.Children = new ArrayList<>();
    }

    /**
     * Function is a getter function that retrieves the name variable
     */
    public String getName() {
        return name;
    }

    /**
     * Function is a getter function that retrieves the type variable
     */
    public String getType() {
        return type;
    }

    /**
     * Function adds children of Celestial Bodies to their ArrayList of Children
     */
    public void add(CelestialBody child) throws DuplicateCelestialBodyException{
        for(CelestialBody Body : Children){
            if(Body.name == child.name){
                throw new DuplicateCelestialBodyException("Duplicate Error: " + name + " is already in the collection");
            } 
        }
        Children.add(child);
        System.out.println("The "+ child.type + " " + child.name +" was added successfully to " + name);
    }

    /**
     * Function is a getter function that retrieves the Children variable
     */
    public ArrayList<CelestialBody> getChildren(){
        return Children;
    }
}
