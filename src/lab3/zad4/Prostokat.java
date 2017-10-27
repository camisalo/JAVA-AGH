package lab3.zad4;

import java.awt.*;

public class Prostokat extends Shape{

    public Prostokat(int a, int b){
        this.pole = a*b;
        name = "Prostokat";
    }



    public void draw(){
        System.out.println("----------");
        for (int i=0;i<10;++i){
            System.out.println("|          |");
        }
        System.out.println("----------");
    }

    @Override
    public void draw(Graphics g){

    }

    public int pole(){
        return pole;
    }
}
