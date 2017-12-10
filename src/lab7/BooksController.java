package lab7;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;


public class BooksController implements Initializable{

    public Button ButtonSearch;
    public TextField pattern;

    public TextField isbnT;
    public TextField titleT;
    public TextField authorT;
    public TextField yerT;

    public ComboBox<String> comboBox;
    public ListView<String> listview;

    public Label info;
    private DB db = new DB();

    public void SearchInDB(){

        ObservableList<String> lista = FXCollections.observableArrayList();;

        System.out.println(comboBox.getValue());
        try {
            lista = db.SearchBooks(comboBox.getValue(), pattern.getText());
            info.setText("Operacja zakończyła się poprawnie");
        }catch(SQLException ex){
            info.setText("Operacja napotkałą problem");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch (Exception e){e.printStackTrace();}

        listview.setItems(lista);
    }

    public void AddBookToDB(ActionEvent actionEvent) {
        String isbn = isbnT.getText();
        String title = titleT.getText();
        String author = authorT.getText();
        String yer = yerT.getText();

        try {
            db.addBook(isbn, title, author, yer);
            info.setText("Dodano książkę poprawnie");
        }catch(SQLException ex){
            info.setText("Błąd przy dodawaniu książki");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().addAll(
                "Wszystko",
                "Autor",
                "ISBN"
        );
        comboBox.getSelectionModel().selectFirst();
        try {
            db.connect();
            info.setText("Połączono z Bazą książek");
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ConnectException e){
            System.out.println("EXIT");
            Platform.exit();
        } catch (Exception e){e.printStackTrace();}
    }
}
