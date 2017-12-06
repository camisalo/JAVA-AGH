package lab7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.StageStyle;

public class Books_DB extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Aplikacja.fxml"));
        primaryStage.setTitle("Books Database");


        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
