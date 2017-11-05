package lab3.zad4;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Shape {
    public String name;
    int pole, x, y;
    public abstract void draw();
    public abstract int pole();
    public abstract void draw(Graphics g);


    public boolean equals(Shape T) {
        if (T.pole() == this.pole)
            return true;
        else
            return false;
    }

    public abstract boolean contains (Point2D p);
    public abstract void move(Point2D p);

}
