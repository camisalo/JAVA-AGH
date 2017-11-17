package Kolokwium;

import java.util.Stack;

public class Dzielenie extends Operator2Arg{

    public Dzielenie(String a){
        wartosc = a;
    }

    @Override
    public double oblicz(Stack<Operator> a) {
        return Double.parseDouble(a.pop().getWartosc()) / Double.parseDouble(a.pop().getWartosc());
    }
}
