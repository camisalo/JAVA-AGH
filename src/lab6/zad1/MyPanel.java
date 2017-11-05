package lab6.zad1;

import lab3.zad4.Shape;
import lab4.zad1.ListaKsztaltow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;


public class MyPanel extends JPanel {
    private ListaKsztaltow ksztalty = new ListaKsztaltow();
    private Shape current;

    public MyPanel(){
        ksztalty.wczytajKsztalty();
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }


    @Override
    public void paint(Graphics g){
        super.paintComponent(g);
        for (Shape e:ksztalty.lista){
            e.draw(g);
        }
    }

    public Shape find(Point2D p){
        for (Shape s:ksztalty.lista){
            if (s.contains(p)) return s;
        }
        return null;
    }


    private class MouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent event){
            current = find(event.getPoint());
        }
    }

    private class MouseMotionHandler implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent event) {
            if (current != null){
                current.move(event.getPoint());
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent event) {
            if (find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
    }
}
