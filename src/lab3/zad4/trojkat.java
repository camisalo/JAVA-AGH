package lab3.zad4;

import java.awt.*;
import java.awt.geom.Point2D;

public class trojkat extends Shape{
    private int a, h;

    public trojkat(int x, int y, int a, int h){
        this.x = x;
        this.y = y;
        this.a = a;
        this.h = h;
        this.pole = (int) 0.5*a*h;
        name = "trojkat";
    }

    public void draw(){
        for (int i=0;i<10;++i){
            System.out.println("Rysuje trójkąt");
        }
    }
    public int pole(){
        return pole ;
    }


    @Override
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        g2.drawLine(x,y,x+a,y);
        g2.drawLine(x,y,x+(a/2),y-h);
        g2.drawLine(x+(a/2),y-h,x+a,y);
        int[] xx = {x,x+(a/2),x+a};
        int[] yy = {y,y-h,y};

        g2.fillPolygon(xx,yy,3);
    }

    @Override
    public boolean contains(Point2D p) {
        if (x <= p.getX() && p.getX() <= x+a && y >= p.getY() && y-h <= p.getY())
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
