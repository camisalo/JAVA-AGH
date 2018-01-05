package lab9.zad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

import static lab9.zad2.Levenshtein.levenshtein;

public class ServerSzymon {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        ExecutorService executorService = null;


        serverSocket = new ServerSocket(5000);
        executorService = Executors.newFixedThreadPool(10);
        while (true) {
            final Socket socket = serverSocket.accept();
            Runnable connection = new Runnable() {
                @Override
                public void run() {
                    String loginpassword = "konrad;maniek";
                    boolean online = false;
                    String ID = "";
                    try {
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String inputLine;
                        System.out.println("elo");
                        int lev;
                        while ((inputLine = in.readLine()) != null) {
                            // LOGOWANIE     do serwera
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
                                    } else {
                                        out.println("nieznana komenda");
                                    }
                                } else if (splitedArray.length == 3) {
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
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.submit(connection);
        }
    }

}