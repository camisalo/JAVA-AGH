package lab3.zad4;

public abstract class Shape {
    public String name;
    int pole;
    public abstract void draw();
    public abstract int pole();

    public boolean equals(Shape T) {
        if (T.pole() == this.pole)
            return true;
        else
            return false;
    }
}
