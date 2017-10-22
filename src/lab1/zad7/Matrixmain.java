package lab1.zad7;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Matrixmain {
    public static void main(String[] args) {
        int [][] Matrix = { {1,2,3} , {1,2,3} , {1,2,3} };
        Matrix M1 = new Matrix(3,3, Matrix);
        Matrix = new int[][] { {9,5,7} , {2,5,3} , {6,8,3} };
        Matrix M2 = new Matrix(3,3, Matrix);
        try {
            Matrix M3 = M1.add(M2);
            Matrix M4 = M1.sub(M2);
            Matrix M5 = M1.mul(M2);
            M3.print();
            M4.print();
            M5.print();
        } catch (MatrixDimensionsException M){
            M.printStackTrace();
        }
        try{
            String patch = "C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab1\\zad7\\matrix";
            Scanner in = new Scanner(Paths.get(patch));
            try{
            Matrix M6 = new Matrix(3,3,in);
            M6.print();
            }finally {
                in.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("M1: ");
        M1.print();
        System.out.println("M2: ");
        M2.print();
    }
}
