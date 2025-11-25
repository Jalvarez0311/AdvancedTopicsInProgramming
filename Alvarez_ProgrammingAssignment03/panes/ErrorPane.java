package Alvarez_ProgrammingAssignment03.panes;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.geometry.Pos;

public class ErrorPane extends VBox{
    public ErrorPane(String errorMessage){
        Label error = new Label(errorMessage);
        Button okButton = new Button("Ok");

        okButton.setOnAction(e -> Platform.exit());

        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.getChildren().addAll(error, okButton);
    }
}
