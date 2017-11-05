package lab3.zad4;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Prostokat extends Shape{
    int a, b;

    public Prostokat(int x, int y, int a, int b){
        this.pole = a*b;
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
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
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(x,y,a,b);
        g2.setPaint(Color.BLUE);
        g2.draw(rect);
        g2.fill(rect);
    }

    @Override
    public boolean contains(Point2D p) {
        if (x <= p.getX() && p.getX() <= x+a && y <= p.getY() && y+b >= p.getY())
            return true;
        else
            return false;
    }

    @Override
    public void move(Point2D p) {
        x =(int) p.getX();
        y =(int) p.getY();
    }

    public int pole(){
        return pole;
    }
}
