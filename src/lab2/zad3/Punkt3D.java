package lab2.zad3;

public class Punkt3D extends Punkt2D {
    protected double Z;
    public Punkt3D(double x, double y, double z){ super(x, y); Z = z; }

    public void setZ(double z){ Z = z; }

    public double getZ() { return Z; }

    public double distance(Punkt3D P3) {
        return Math.sqrt(Math.pow(X-P3.getX(),2)+Math.pow(Y-P3.getY(),2)+Math.pow(Z-P3.getZ(),2));
    }
}
