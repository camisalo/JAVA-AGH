package lab3.zad4;

public class ShapeTest {

    public static void main(String[] args) {
        Shape S = new Kwadrat(5);
        System.out.println(S.name);
        S.draw();

        S = new Prostokat(3,2);
        System.out.println(S.name);
        S.draw();

        S = new trojkat(3,6);
        System.out.println(S.name);
        S.draw();
    }
}
