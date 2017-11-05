package lab6.zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class PanelWielomian extends JPanel {
    double A,B,C,D,S,E;
    int DIV;

    public PanelWielomian(){

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // Rysowanie Osi
        g2.draw(new Line2D.Double(0,300,1000,300));
        g2.draw(new Line2D.Double(500,0,500,600));

        // Rysowanie Wielomianu
        for (int i=0; i<DIV; ++i){

        }

    }

    private Point2D calc(double x) {
        return
    }

    public void LoadABCD(double a, double b, double c, double d, double s, double e, int div){
        A = a; B = b; C = c; D = d; S = s; E = e; DIV = div;
    }
}
