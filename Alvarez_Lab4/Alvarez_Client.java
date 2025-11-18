package Alvarez_Lab4;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Alvarez_Client extends Application{
    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberofYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private Button btSubmit = new Button("Submit");
    private TextArea ta = new TextArea();

    DataOutputStream osToServer;
    DataInputStream isFromServer;
    @Override
    public void start (Stage primaryStage){
        ta.setWrapText(true);
        GridPane gridpane = new GridPane();
        gridpane.add(new Label("Annual Interest Rate"), 0, 0);
        gridpane.add(new Label("Number of Years"), 0, 1);
        gridpane.add(new Label("Loan Amount"), 0, 2);
        gridpane.add(tfAnnualInterestRate, 1, 0);
        gridpane.add(tfNumberofYears, 1, 1);
        gridpane.add(tfLoanAmount, 1, 2);
        gridpane.add(btSubmit, 2, 1);



        BorderPane pane = new BorderPane();
        pane.setCenter(new ScrollPane(ta));
        pane.setTop(gridpane);
        
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        btSubmit.setOnAction(e -> sendInfoToServer());
        
        try{//Home IP can be replaced with "localhost"

            Socket connectToServer = new Socket("127.0.0.1", 8000);
            isFromServer = new DataInputStream(connectToServer.getInputStream());
            osToServer = new DataOutputStream(connectToServer.getOutputStream());
        }
        catch (IOException e){
            ta.appendText(toString() + '\n');
        }
    }
    private void sendInfoToServer(){
        try{
            double annualInterestRate = Double.parseDouble(tfAnnualInterestRate.getText().trim());
            int numOfYears = Integer.parseInt(tfNumberofYears.getText().trim());
            double loanAmount = Double.parseDouble(tfLoanAmount.getText().trim());
            osToServer.writeDouble(annualInterestRate);
            osToServer.writeInt(numOfYears);
            osToServer.writeDouble(loanAmount);
            osToServer.flush();

            double monthlyPayment = isFromServer.readDouble();
            double totalPayment = isFromServer.readDouble();

            ta.appendText("Annual Interest Rate" + annualInterestRate + "\n" + 
            "Number of Years" + numOfYears + "\n" + "Loan Amount" + loanAmount + "\n");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        launch(args);
    }
}
