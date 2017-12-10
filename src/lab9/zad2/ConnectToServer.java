package lab9.zad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectToServer {


    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("szymon.ia.agh.edu.pl", 3000);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: szymon.ia.agh.edu.pl.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: szymon.ia.agh.edu.pl.");
            System.exit(1);
        }
        System.out.println("elo");

    }
}