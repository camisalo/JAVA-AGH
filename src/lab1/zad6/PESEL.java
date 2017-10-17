package lab1.zad6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PESEL {
    private String Pesel;
    public void LoadPESEL(){
        try {
            System.out.print("Podaj swój pesel: ");
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader buffer = new BufferedReader(reader);
            Pesel = buffer.readLine();
        }catch(IOException e){e.printStackTrace();}
    }

    public boolean check(){
        int sum = 0, V[] = {9,7,3,1,9,7,3,1,9,7};
        if (Pesel.length() != 11)
            return false;
        for (int i=0;i<10;++i){
            sum = sum + (V[i] * Integer.parseInt(Pesel.substring(i,i+1)));
        }
        System.out.println("wyliczona suma = " + sum + "\nOstatnia liczba w PESELU (11) = " + Pesel.substring(10));
        if (sum%10 == Integer.parseInt(Pesel.substring(10))){
            return true;
        } else{
            return false;
        }
    }

}
