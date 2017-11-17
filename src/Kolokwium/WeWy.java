package Kolokwium;


import java.util.Stack;

public class WeWy {
    public Stack<Operator> Pobierzdzialanie(String rownanie){


        Stack<Operator> stos = new Stack<>();
        String[] podzielonerownanie = null;
        podzielonerownanie = rownanie.split(" ");
        for (String a : podzielonerownanie) {
            if (a.equals("/"))
                stos.push(new Dzielenie(a));
            else if(a.equals("*"))
                stos.push(new Mnozenie(a));
            else if (a.equals("+"))
                stos.push(new Dodawanie(a));
            else if (a.equals("!"))
                stos.push(new Silnia(a));
            else
                stos.push(new Stala(a));
        }

        return stos;
    }

    public static void Wyniki(double v){
        System.out.println(v);
    }
}
