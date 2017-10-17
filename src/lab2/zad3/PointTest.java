package lab2.zad3;

import java.util.LinkedList;
import java.util.Scanner;

public class PointTest {

    LinkedList<Punkt3D> points = new LinkedList<Punkt3D>();

    public static void main(String[] args) {
        PointTest P = new PointTest(); int k=0;
        Scanner in = new Scanner(System.in);
        while (k != 4) {
            System.out.println("\n1. Wczytaj punkt 3D\n" +
                                "2. Wyświetl wszystkie punkty\n" +
                                "3. Oblicz odległość\n" +
                                "4. Zakończ\n" +
                                "?\n");
            k = in.nextInt();
            switch (k) {
                case 1:
                    P.NewPoint();
                    break;
                case 2:
                    P.PrintPoints();
                    break;
                case 3:
                    P.PrintPoints();
                    System.out.println("Wybierz pierszy punkt: ");
                    int a = in.nextInt();
                    System.out.println("Wybierz drugi punkt: ");
                    int b = in.nextInt();
                    System.out.println("Odległość między punktami wynosi: " +
                            P.points.get(a-1).distance(P.points.get(b-1)));
                    break;
                case 4:
                    System.out.println("Zamykanie programu....");
                    break;
                default:
                    System.out.println("Podano zły numer.");
                    break;
            }
            try {
                Runtime.getRuntime().exec("cls");
            }catch(final Exception e){ }
        }

    }

    public void NewPoint(){
        double x,y,z;
        Scanner in = new Scanner(System.in);
        System.out.println("X = "); x = in.nextDouble();
        System.out.println("Y = "); y = in.nextDouble();
        System.out.println("Z = "); z = in.nextDouble();
        Punkt3D temp = new Punkt3D(x,y,z);
        points.add(temp);
    }

    public void PrintPoints(){
        int i=1;
        for (Punkt3D P : this.points){
            System.out.println(i + ". [" + P.getX() + "; " + P.getY() + "; " + P.getZ() +"]");
            i++;
        }
    }
}