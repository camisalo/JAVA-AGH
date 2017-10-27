package lab4.zad1;


import lab3.zad4.Kwadrat;
import lab3.zad4.Prostokat;
import lab3.zad4.Shape;
import lab3.zad4.trojkat;

import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import lab3.zad4.Shape;

public class ListaKsztaltow {
    private LinkedList<Shape> lista = new LinkedList<>();

    public void add(Shape S){
        lista.add(S);
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
    }



}
