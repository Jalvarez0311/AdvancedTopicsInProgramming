package Alvarez_ProgrammingAssignment03;
/** 
 * This class defines the Star object of the virtual solar system model
 * @author J. Alvarez
 * 2588
 * SolarSystem.java
 * 3/25/2025
 */
import Alvarez_ProgrammingAssignment03.solarsystem.Moon;
import Alvarez_ProgrammingAssignment03.solarsystem.Planet;
import Alvarez_ProgrammingAssignment03.solarsystem.Star;
import Alvarez_ProgrammingAssignment03.panes.ErrorPane;
import Alvarez_ProgrammingAssignment03.panes.SolarSystemPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class SolarSystem extends Application{
    /**
     * Function is the start function to run the javaFX program
     * @param primaryStage -this variable holds the stage for the javaFX program
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            SolarSystemPane solarSystemPane = new SolarSystemPane();

            // Create the star (Sun)
            Star sun = new Star("Sun", 5778, Color.YELLOW, 100);
            solarSystemPane.addStar(sun);

            // Create planets
            Planet mercury = new Planet("Mercury", sun, Color.GRAY, 10);
            Planet venus = new Planet("Venus", sun, Color.BROWN, 20);
            Planet earth = new Planet("Earth", sun, Color.BLUE, 20);
            Planet mars = new Planet("Mars", sun, Color.RED, 15);
            Planet jupiter = new Planet("Jupiter", sun, Color.ORANGE, 60);
            Planet saturn = new Planet("Saturn", sun, Color.GOLD, 50);
            Planet uranus = new Planet("Uranus", sun, Color.CYAN, 40);
            Planet neptune = new Planet("Neptune", sun, Color.BLUE, 40);

            // Adding planets to the solar system
            solarSystemPane.addPlanet(mercury, 110);
            solarSystemPane.addPlanet(venus, 150);
            solarSystemPane.addPlanet(earth, 200);
            solarSystemPane.addPlanet(mars, 250);
            solarSystemPane.addPlanet(jupiter, 325);
            solarSystemPane.addPlanet(saturn, 415);
            solarSystemPane.addPlanet(uranus, 490);
            solarSystemPane.addPlanet(neptune, 560);

            // Create moons
            Moon moon = new Moon("Moon", earth, Color.LIGHTGRAY, 5);
            Moon phobos = new Moon("Phobos", mars, Color.GRAY, 3);
            Moon deimos = new Moon("Deimos", mars, Color.DARKGRAY, 3);
            solarSystemPane.addMoon(moon, 20);
            solarSystemPane.addMoon(phobos, 15);
            solarSystemPane.addMoon(deimos, 20);

            // Set up the scene
            Scene scene = new Scene(solarSystemPane, 800, 800);
            primaryStage.setTitle("Solar System");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            ErrorPane errorPane = new ErrorPane("An error occurred: " + e.getMessage());
            Scene errorScene = new Scene(errorPane, 300, 200);
            Stage errorStage = new Stage();
            errorStage.setTitle("Error");
            errorStage.setScene(errorScene);
            errorStage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}