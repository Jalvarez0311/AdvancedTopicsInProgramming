package Alvarez_Lab4;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Alvarez_Server extends Application{
    
    private TextArea ta = new TextArea();
    
    @Override
    public void start (Stage primaryStage){
        Scene scene = new Scene(new ScrollPane(ta), 300, 250);
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> connectToClient()).start();
    }

    private void connectToClient(){
        try{
            ServerSocket serverSocket = new ServerSocket(8000);
            Platform.runLater(()-> ta.appendText("Server started on port 800 on " + new Date() + "\n"));
            //listening to client
            Socket connectToClient = serverSocket.accept();

            Platform.runLater(()-> ta.appendText("Connected to a client at " + new Date() + "\n"));
            DataInputStream isFromClient = new DataInputStream(connectToClient.getInputStream());
            DataOutputStream osToClient = new DataOutputStream(connectToClient.getOutputStream());

            while (true){
                double annualInterestRate = isFromClient.readDouble();
                int numOfYears = isFromClient.readInt();
                double loanAmount = isFromClient.readDouble();

                Loan mortgage = new Loan(annualInterestRate, numOfYears, loanAmount);
                double monthlyPayment = mortgage.getMonthlyPayment();
                double totalPayment = mortgage.getTotalPayment();

                //send results back to the client
                osToClient.writeDouble(monthlyPayment);
                osToClient.writeDouble(totalPayment);

                Platform.runLater(() -> ta.appendText("Annual Interest Rate :" + annualInterestRate + "\n" 
                + "Number of Years :" + numOfYears + "\n" 
                + "Monthly Payment :" + monthlyPayment + "\n" 
                + "Total PAyment :" + totalPayment + "\n"));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
