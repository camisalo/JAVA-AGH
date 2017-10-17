package lab1.zad7;

public class Matrixmain {
    public static void main(String[] args) {
        int [][] Matrix = { {1,2,3} , {1,2,3} , {1,2,3} };
        Matrix M1 = new Matrix(3,3, Matrix);
        Matrix = new int[][] { {9,5,7} , {2,5,3} , {6,8,3} };
        Matrix M2 = new Matrix(3,3, Matrix);
        Matrix M3 = M1.add(M2);
        Matrix M4 = M1.sub(M2);
        Matrix M5 = M1.mul(M2);

        System.out.println("M1: ");
        M1.print();
        System.out.println("M2: ");
        M2.print();
        System.out.println("Dodawanie: ");
        M3.print();
        System.out.println("Odejmowanie: ");
        M4.print();
        System.out.println("Mnożenie: ");
        M5.print();
    }
}
