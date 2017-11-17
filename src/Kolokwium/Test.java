package Kolokwium;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        try( Scanner odczyt = new Scanner(new File("C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\Kolokwium\\plik")))
        {
            WeWy W = new WeWy();

            while (odczyt.hasNext()){
                Stack<Operator> S = new Stack<>();
                S = W.Pobierzdzialanie(odczyt.nextLine());

                double wynik;
                wynik = S.pop().oblicz(S);
                WeWy.Wyniki(wynik);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
