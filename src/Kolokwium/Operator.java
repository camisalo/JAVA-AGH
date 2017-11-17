package Kolokwium;

import java.util.Stack;

public abstract class Operator implements Obliczanie {

    String wartosc;

    public double oblicz(Stack<Operator> a){
        return 2.23;
    }

    public String getWartosc(){
        return wartosc;
    }
}
