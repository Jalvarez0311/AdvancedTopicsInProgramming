package Alvarez_ProgrammingAssignment03.solarsystem;

import javafx.scene.paint.Color;
import java.util.ArrayList;

import Alvarez_ProgrammingAssignment02.Exceptions.DuplicateCelestialBodyException;
import javafx.scene.shape.Circle;

/** 
 * This class defines the Celestial Body object of the virtual solar system model
 * @author J. Alvarez
 * 2588
 * SolarSystem.java
 * 3/25/2025
 */
public class CelestialBody extends Circle{
    private String name;
    private String type;
    private ArrayList<CelestialBody> Children;

    /**
     * Function is a constructor for the CelestialBody class
     * @param name -string value to be the name of the Celestial Body object
     * @param type -string value to define the type of Celestial Body the object will be
     */
    public CelestialBody(String name, String type, Color color, double radius){
        this.name = name;
        this.type = type;
        this.setFill(color);
        this.setRadius(radius);
        this.Children = new ArrayList<>();

        this.setOnMouseClicked(e -> getInformation());
    }

    /**
     * Function is a getter function that retrieves the name variable
     */
    public String getName(){
        return name;
    }

    /**
     * Function is a getter function that retrieves the type variable
     */
    public String getType(){
        return type;
    }

    /**
     * Function adds children of Celestial Bodies to their ArrayList of Children
     */
    public void add(CelestialBody child) throws DuplicateCelestialBodyException{
        for(CelestialBody Body : Children){
            if(Body.name.equals(child.name)){
                throw new DuplicateCelestialBodyException("Duplicate Error: " + child.type + " " + child.name + " is already in the collection");
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

    /**
     * Function is a getter function to display the information of the celestial body to the user
     */
    public void getInformation(){
        System.out.println("This is the " + type + " " + name);
    }
}
