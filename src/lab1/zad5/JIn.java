package lab1.zad5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JIn {
    int number;
    void LoadNumber(){
        try {
            System.out.print("Podaj liczbę pierwszą: ");
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader buffer = new BufferedReader(reader);
            number = Integer.parseInt(buffer.readLine());
        }catch(IOException e){e.printStackTrace();}
    }
}
