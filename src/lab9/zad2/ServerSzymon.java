package lab9.zad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

import static lab9.zad2.Levenshtein.levenshtein;

public class ServerSzymon {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        String loginpassword = "konrad;maniek";
        String ID="";
        boolean online = false;

        try{
            serverSocket = new ServerSocket(5000);
        } catch (IOException e){
            System.out.println("Could not listen on port: 5000");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e){
            System.out.println("Brak połączenia: 5000");
            System.exit(-1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine;
        System.out.println("elo");
        int lev;
        while ((inputLine = in.readLine()) != null) {
            // LOGOWANIE do serwera
            if (!online) {
                if ((lev = levenshtein(loginpassword, inputLine)) == 0) {
                    ID = "1234567890";
                    online = true;
                    out.println(ID);
                } else {
                    out.println(lev);
                }
            }

            // Obsługa komend po zalogowaniu
            else if (online) {
                String[] splitedArray = inputLine.split(" ");
                if (splitedArray.length == 2) {
                    if (splitedArray[0].equals("LOGOUT") && splitedArray[1].equals(ID)) {
                        out.println("LOGOUT");
                        break;
                    } else if (splitedArray[0].equals("LS") && splitedArray[1].equals(ID)) {
                        out.println("plik1;plik2;plik3");
                    } else{
                        out.println("nieznana komenda");
                    }
                } else if (splitedArray.length == 3){
                    if (splitedArray[0].equals("GET") && splitedArray[1].equals(ID)) {
                        out.println("Zawartość pliku: " + splitedArray[2]);
                    } else {
                        out.println("nieznana komenda");
                    }
                } else {
                    out.println("nieznana komenda");
                }
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}