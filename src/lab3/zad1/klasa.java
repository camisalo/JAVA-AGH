package lab3.zad1;

import java.util.LinkedList;

public class klasa {
    public static void main(String[] args) {
        final double var = 10;
        klasa k = new klasa();
        k.finalTest(var);
        final LinkedList<Double> list = new LinkedList<>();
        k.finalTestList(list);
    }

    private void finalTest(final double var){
        //var =121; nie mozna zmienic;
    }

    private void finalTestList(final LinkedList<Double> var){
        var.add(12.24);
        var.add(213.1234);
        var.add(123.412);
        var.remove(12.24);
        for (double i:var){
            i = 123;
        }
        System.out.println(var.toString());
    }
}
