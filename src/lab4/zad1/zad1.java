package lab4.zad1;


import lab3.zad4.Kwadrat;
import lab3.zad4.Prostokat;
import lab3.zad4.Shape;
import lab3.zad4.trojkat;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class zad1 {
    public static void main(String[] args) {
        LinkedList<Shape> lista = new LinkedList<>();
        lista.add(new Kwadrat(2));
        lista.add(new trojkat(3,4));
        lista.add(new Prostokat(2,4));
        lista.add(new Kwadrat(5));
        lista.add(new Kwadrat(6));
        lista.add(new trojkat(32,3));
        lista.add(new Prostokat(2,23));
        lista.add(new Kwadrat(7));
        lista.add(new Kwadrat(8));
        lista.add(new trojkat(9,4));
        lista.add(new Prostokat(23,4));
        lista.add(new Kwadrat(1));
        lista.add(new Kwadrat(232));
        lista.add(new trojkat(24,2));
        lista.add(new Prostokat(2,212));
        lista.add(new Kwadrat(94));
        lista.add(new Prostokat(3242,221));
        lista.add(new Kwadrat(124));
        lista.add(new Kwadrat(124));
        lista.add(new trojkat(532,12));
        for (Shape i:lista){
            System.out.print(i.pole() + " ,");
        }

        Collections.sort(lista,new Comparator<Shape>() {
                    @Override
                    public int compare(Shape T1, Shape T2) {
                        if (T1.pole() < T2.pole())
                            return -1;
                        else if (T1.pole() > T2.pole())
                            return 1;
                        return 0;

                    }
                });


        System.out.println(" ");
        for (Shape i:lista){
            System.out.print(i.pole() + " ,");
        }
    }
}
