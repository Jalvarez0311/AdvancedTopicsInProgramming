package Alvarez_Lab3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class Lab3 extends Application{
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        Circle circle = new Circle(100, 100, 50);
        pane.getChildren().add(circle);

        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setOnMousePressed(e -> circle.setFill(Color.BLACK));
        circle.setOnMouseReleased(e -> circle.setFill(Color.WHITE));

        circle.setFocusTraversable(true);
        circle.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.UP){
                circle.setCenterY(circle.getCenterY()-2);
            }
            else if(e.getCode() == KeyCode.DOWN){
                circle.setCenterY(circle.getCenterY()+2);
            }
            else if(e.getCode() == KeyCode.LEFT){
                circle.setCenterX(circle.getCenterX()-2);
            }
            else if(e.getCode() == KeyCode.RIGHT){
                circle.setCenterX(circle.getCenterX()+2);
            }

        });
        
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Moving Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}



