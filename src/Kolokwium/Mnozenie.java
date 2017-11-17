package Kolokwium;

import java.util.Stack;

public class Mnozenie extends Operator2Arg{

    public Mnozenie(String a){
        wartosc = a;
    }

    @Override
    public double oblicz(Stack<Operator> a) {
        return Double.parseDouble(a.pop().getWartosc()) / Double.parseDouble(a.pop().getWartosc());
    }
}
