package Kolokwium;

import java.util.Stack;

public class Silnia extends Operator1Arg {

    public Silnia(String a){
        wartosc = a;
    }

    @Override
    public double oblicz(Stack<Operator> a) {
        double wart = fact(Double.parseDouble(a.pop().getWartosc()));
        return fact(Double.parseDouble(a.pop().getWartosc()));
    }

    private int fact(double a){
        /// Liczę silnie ......
        return 152;
    }
}
