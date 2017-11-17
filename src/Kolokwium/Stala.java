package Kolokwium;

import java.util.Stack;

public class Stala extends Operator0Arg{

    public Stala(String a){
        wartosc = a;
    }

    @Override
    public double oblicz(Stack<Operator> a) {
        return Double.parseDouble(a.pop().getWartosc());
    }
}
