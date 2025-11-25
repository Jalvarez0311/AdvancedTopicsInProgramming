package Alvarez_ProgrammingAssignment03.panes;

import Alvarez_ProgrammingAssignment03.solarsystem.CelestialBody;
import Alvarez_ProgrammingAssignment03.solarsystem.Moon;
import Alvarez_ProgrammingAssignment03.solarsystem.Star;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SolarSystemPane extends Pane{
    public SolarSystemPane(){
setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));    }

    public void addStar(Star star){
        star.setCenterX(0);
        star.setCenterY(0);
        getChildren().add(star);
    }

    public void addPlanet(Alvarez_ProgrammingAssignment03.solarsystem.Planet planet, double distance){
        Circle orbit = new Circle(0, 0, (distance * 1.43), Color.TRANSPARENT);
        orbit.setStroke(Color.GRAY);
        orbit.setMouseTransparent(true);

        orbit.setCenterX(planet.getLayoutX());
        orbit.setCenterY(planet.getLayoutY());

        planet.setLayoutX(planet.getLayoutX() + distance);
        planet.setLayoutY(planet.getLayoutY() + distance);

        getChildren().addAll(orbit, planet);
    }

    public void addMoon(Moon moon, double distance){
        CelestialBody planet = moon.getOrbit();
        Circle orbit = new Circle();
        orbit.setFill(null);
        orbit.setStroke(javafx.scene.paint.Color.GRAY);
        orbit.setMouseTransparent(true);
        orbit.setRadius(planet.getRadius() + distance - 9);
        this.getChildren().add(orbit);

        orbit.setCenterX(planet.getLayoutX());
        orbit.setCenterY(planet.getLayoutY());

        moon.setLayoutX(planet.getLayoutX() + distance);
        moon.setLayoutY(planet.getLayoutY() + distance);
        this.getChildren().add(moon);
    }
}
