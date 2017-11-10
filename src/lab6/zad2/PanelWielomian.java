package lab6.zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.text.NumberFormat;

public class PanelWielomian extends JPanel {
    private double A,B,C,D,S,E;
    private int DIV;
    private double skalaX,skalaY;

    double MAX=0, MAX_X=0, MIN=0, MIN_X=0;

    public PanelWielomian(){

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        calcScale();

        // Rysowanie Osi

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);

        g2.setFont(new Font("TimesRoman",Font.PLAIN,12));
        g2.setColor(Color.GRAY);
        String osie;
        for (int i=0;i<11;++i){
            osie = nf.format(S + i*(Math.abs(E-S)/10));
            g2.drawString(osie,5 + i*100,12);
            g2.draw(new Line2D.Double(i*100,0,i*100,600));

            osie = nf.format(MAX - i*(Math.abs(MAX-MIN)/10));
            g2.drawString(osie,5,i*60);
            g2.draw(new Line2D.Double(0,i*60,1000,i*60));
        }

        g2.setFont(new Font("TimesRoman",Font.BOLD,25));

        nf.setMaximumFractionDigits(5);
        g2.drawString("MAX: [" + nf.format(MAX_X) + " , " + nf.format(MAX) + "]",700,500);
        g2.drawString("MIN: [" + nf.format(MIN_X) + " , " + nf.format(MIN) + "]",700,525);

        // Rysowanie Wielomianu
        double P1, P2;
        g2.setColor(Color.BLUE);
        for (int i=0; i<DIV; ++i){
            P1 = S + (i * Math.abs(E-S)/DIV);
            P2 = S + ((i+1)* Math.abs(E-S)/DIV);
            Line2D L = new Line2D.Double(calcPoint(P1), calcPoint(P2));
            g2.draw(L);
        }

        // MAX, MIN
        g2.setColor(Color.RED);
        g2.fill(new Ellipse2D.Double((MAX_X-S)*skalaX-5,300-MAX*skalaY-5,10,10));
        g2.fill(new Ellipse2D.Double((MIN_X-S)*skalaX-5,300-MIN*skalaY-5,10,10));
    }

    private Point2D calcPoint(double x) {
        return new Point2D.Double((x-S)*skalaX,300-((A*Math.pow(x,3) + B*Math.pow(x,2) + C*x + D)*skalaY));
    }
    private void calcScale(){
        double odcinek = Math.abs(E-S)/DIV;
        double x, wynik, M;
        for (int i=0;i<DIV;++i){
            x = S + i*odcinek;
            wynik =A*Math.pow(x,3) + B*Math.pow(x,2) + C*x + D;
            if (MAX < wynik) {
                MAX = wynik; MAX_X = x;
            }
            if (MIN > wynik) {
                MIN = wynik; MIN_X = x;
            }
        }
        if (Math.abs(MIN) > Math.abs(MAX))
            M = Math.abs(MIN);
        else
            M = Math.abs(MAX);

        skalaY = 300/M;
        skalaX = 1000/Math.abs(E-S);

    }

    public void LoadABCD(double a, double b, double c, double d, double s, double e, int div){
        A = a; B = b; C = c; D = d; S = s; E = e; DIV = div;
    }
}
