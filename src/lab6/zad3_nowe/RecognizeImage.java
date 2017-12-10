package lab6.zad3_nowe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class RecognizeImage extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab6\\zad3_nowe\\Okno.fxml"));

        StackPane stackPlane = loader.load();

        Scene scene = new Scene(stackPlane);

        primaryStage.setTitle("Rozpoznawanie Obrazów");
        primaryStage.show();

    }
}