package lab3.zad4;

public class ShapeTest {

    public static void main(String[] args) {
        Shape S = new Kwadrat(20,10,5);
        System.out.println(S.name);
        S.draw();

        S = new Prostokat(2,5,3,2);
        System.out.println(S.name);
        S.draw();

        S = new trojkat(2,6,3,6);
        System.out.println(S.name);
        S.draw();
    }
}
