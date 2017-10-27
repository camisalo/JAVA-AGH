package lab4.zad5;

import java.util.Scanner;

public class Zad5Test {
    public static void main(String[] args) {
        Algorithm R11 = new ROT11();
        Algorithm polibiusz = new Polibiusz();
        Scanner in = new Scanner(System.in);
        int i=0;
        while (i != 5) {
            System.out.println("co chcesz zrobić:" +
                    "\n1. zaszyfruj ROT11." +
                    "\n2. zaszyfruj Polibiusem." +
                    "\n3. deszyfruj ROT11." +
                    "\n4. deszyfruj Polibiusem." +
                    "\n5. zakoncz.");
            System.out.println(args[0]);
            i = in.nextInt();
            switch (i) {
                case 1:
                    Cryptographer.cryptfile("C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab4\\zad5\\" + args[0],
                            "C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab4\\zad5\\" + args[1],
                            R11);
                    System.out.println("Zrobione");
                    break;
                case 2:
                    Cryptographer.cryptfile("C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab4\\zad5\\" + args[0],
                            "C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab4\\zad5\\" + args[2],
                            polibiusz);
                    System.out.println("Zrobione");
                    break;
                case 3:
                    Cryptographer.decryptfile("C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab4\\zad5\\" + args[1],
                            "C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab4\\zad5\\" + args[3],
                            R11);
                    System.out.println("Zrobione");
                    break;
                case 4:
                    Cryptographer.decryptfile("C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab4\\zad5\\" + args[2],
                            "C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab4\\zad5\\" + args[4],
                            polibiusz);
                    System.out.println("Zrobione");
                    break;
                case 5:
                    System.out.println("Kończenie programu..........");
                    break;
                default:
                    System.out.println("Błędnny numer.");
                    break;
            }
        }
    }
}