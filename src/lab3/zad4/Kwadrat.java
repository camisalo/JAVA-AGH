package lab3.zad4;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Kwadrat extends Shape {

    private int a;
    public Kwadrat(int x, int y, int a){
        this.pole = a*a;
        this.a = a;
        this.x = x;
        this.y = y;
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
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(x,y,a,a);
        g2.setPaint(Color.RED);
        g2.draw(rect);
        g2.fill(rect);
    }

    @Override
    public boolean contains(Point2D p) {
        if (x <= p.getX() && p.getX() <= x+a && y <= p.getY() && y+a >= p.getY())
            return true;
        else
            return false;
    }

    @Override
    public void move(Point2D p) {
        x =(int) p.getX();
        y =(int) p.getY();
    }
}
