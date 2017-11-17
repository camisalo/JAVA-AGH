package Kolokwium;

import java.util.Stack;

public abstract class Operator0Arg extends Operator {
    @Override
    public double oblicz(Stack<Operator> a) {
        return Double.parseDouble(a.pop().getWartosc());
    }
}
