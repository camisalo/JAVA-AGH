package lab3.zad4;

import java.awt.*;

public class Kwadrat extends Shape {

    private int a;
    public Kwadrat(int a){
        this.pole = a*a;
        this.a = a;
        name = "Kwadrat";
    }

    @Override
    public void draw(){
        System.out.println("----------");
        for (int i=0;i<4;++i){
            System.out.println("|          |");
        }
        System.out.println("----------");
    }
    public int pole(){
        return pole ;
    }

    @Override
    public void draw(Graphics g){
        g.drawRect(0,0,a ,a);
    }
}
