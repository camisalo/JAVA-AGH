package lab3.zad4;

public class ShapeTest {

    public static void main(String[] args) {
        Shape S = new Kwadrat();
        System.out.println(S.name);
        S.draw();

        S = new Prostokat();
        System.out.println(S.name);
        S.draw();

        S = new trojkat();
        System.out.println(S.name);
        S.draw();
    }
}
