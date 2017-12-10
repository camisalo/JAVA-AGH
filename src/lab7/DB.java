package lab7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.text.html.ListView;
import java.sql.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertTrue;

public class DB{
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void connect() throws SQLException, Exception, ConnectException{
        int i=0;
        while(i<3 && conn==null ) {
            i++;
            System.out.println("Próba połączenia " + i);
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try {
                conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/camisalo",
                        "camisalo", "8hkat8iDCcNjVjFM");
            }catch (SQLException ex){}
            if (i==3 && conn==null)

                throw new ConnectException();
        }

    }


    public ObservableList<String> SearchBooks(String sortby, String key) throws SQLException, Exception{

        stmt = conn.createStatement();

        Pattern pattern;
        if (sortby.equals("Wszystko")) {
            pattern = Pattern.compile("");
        } else {
            pattern = Pattern.compile(key);
        }
        rs = stmt.executeQuery("SELECT * FROM books");
        ObservableList<String> lista = FXCollections.observableArrayList();
        while (rs.next()) {
            String isbn = rs.getString(1);
            String title = rs.getString(2);
            String author = rs.getString(3);
            String yer = rs.getString(4);



            if (sortby.equals("Autor")){
                if (pattern.matcher(author).find())
                    lista.add(isbn + "---" + title + "---" + author + "---" + yer);
                System.out.println("Sort: Autor");
            } else if (sortby.equals("ISBN")){
                if (pattern.matcher(isbn).find())
                    lista.add(isbn + "---" + title + "---" + author + "---" + yer);
                System.out.println("Sort: ISBN");
            } else {
                lista.add(isbn + "---" + title + "---" + author + "---" + yer);
                System.out.println("Sort: Wszytako");
            }
            System.out.println("Uzytkownik: " + isbn);

        }
        return lista;
    }

    public void addBook(String isbn, String title, String author, String yer) throws SQLException, Exception{

        stmt = conn.createStatement();
        stmt.executeUpdate("INSERT books VALUES ('"+isbn+"' , '"+title+"' , '"+author+"' , '"+yer+"')");

    }

    public void close(){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) { }
            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { }

            stmt = null;
        }
    }
}