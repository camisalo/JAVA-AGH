package Kolokwium;

import java.util.Stack;

public class Dodawanie extends Operator2Arg{

    public Dodawanie(String a){
        wartosc = a;
    }

    @Override
    public double oblicz(Stack<Operator> a) {
        return Double.parseDouble(a.pop().getWartosc()) + Double.parseDouble(a.pop().getWartosc());
    }
}
