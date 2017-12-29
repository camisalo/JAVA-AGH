package lab9.zad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public class ServerSzymon {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

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

        while ((inputLine = in.readLine()) != null) {
            if (Pattern.compile("LOGIN").matcher(inputLine).find()){
                String login =
                String paswd = inputLine.substring(Pattern.compile("[A-Z][a-z]{1,10}+;").matcher(inputLine).start(),
                        Pattern.compile("[A-Z][a-z]{1,10}+;").matcher(inputLine).end()) // cos nie tak
            } else if (Pattern.compile("LOGOUT").matcher(inputLine).find()){
                System.out.println("Logout!!!");
            } else if (Pattern.compile("LS").matcher(inputLine).find()){
                System.out.println("LS!!");
            } else if (Pattern.compile("GET").matcher(inputLine).find()){
                System.out.println("GET!!!");
            } else {
                System.out.println("Unknown command");
            }

        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
