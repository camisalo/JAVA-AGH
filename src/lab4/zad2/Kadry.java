package lab4.zad2;

import lab1.zad6.PESEL;

import java.sql.*;

public class Kadry {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public Kadry(){
        createTable();
    }

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/camisalo",
                    "camisalo", "8hkat8iDCcNjVjFM");
        }catch (SQLException ex){
            System.out.println("ERROR: " + ex.getErrorCode());
        } catch (Exception e) {e.printStackTrace();}
    }

    public void dodajPracownika(Pracownik P){
        try{
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "INSERT kadrt1 VALUES ('"+P.pesel.getPesel()+"' , '"+P.pobierzWynagrodzenieBrutto()+"')");
        }catch (SQLException ex){
            System.out.println("ERROR: " + ex.getErrorCode());
        } catch (Exception e) {e.printStackTrace();}

    }

    public void usunPracownika(PESEL pesel){
//        int id=0;
//        for (Pracownik p: baza) {
//            if (p.pesel.getPesel().equals(pesel.getPesel())) {
//                baza.remove(id);
//                break;
//            }
//            id++;
//        }
    }

    public void zmienWynagrodzenie(Pracownik P, double wynagrodzenie){
//        for (Pracownik p: baza){
//            if (p.pesel.getPesel().equals(P.pesel.getPesel())){
//                p.zmienwynagrodzenie(wynagrodzenie);
//            }
//        }
    }

    public double pobierzWynagrodzenieBrutto(Pracownik P){
//        for (Pracownik p: baza){
//            if (p.pesel.getPesel().equals(P.pesel.getPesel())){
//                return p.pobierzWynagrodzenieBrutto();
//            }
//        }
        return -1;
    }

    public double pobierzWynagrodzenieNetto(Pracownik P){
//        for (Pracownik p: baza){
//            if (p.pesel.getPesel().equals(P.pesel.getPesel())){
//                return p.obliczWynagrodzenieNetto();
//            }
//        }
        return -1;
    }


    public void createTable(){
        try{
            connect();
            stmt = conn.createStatement();
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS kadry1 ("
                            + "pesel CHAR(11) NOT NULL,"
                            + "wynagrodzenieB VARCHAR(64) NOT NULL,"
                            + "PRIMARY KEY (pesel)");
        }catch (SQLException ex){
            System.out.println("ERROR: " + ex.getErrorCode());
        } catch (Exception e) {e.printStackTrace();}

    }
}

