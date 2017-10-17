package lab2.zad3;

public class Punkt2D {
    protected double X,Y;

    public Punkt2D(double x, double y){
        X = x; Y = y;
    }

    public double getX(){return X;}
    public double getY(){return Y;}
    public void setX(double x){X = x;}
    public void setY(double y){Y = y;}
    public double distance(Punkt2D P2){
        return Math.sqrt(Math.pow(X-P2.getX(),2)+Math.pow(Y-P2.getY(),2));
    }


}