package lab5.zad2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import lab1.zad7.Matrix;
import lab1.zad7.MatrixDimensionsException;

public class DummyMatrixmain {
    public static void main(String[] args) {
        int [][] Matrix = { {1,2,3,4} , {1,2,3,4} , {1,2,3,4} };
        DummyMatrix M1 = new DummyMatrix(3,4, Matrix);
        Matrix = new int[][] { {9,5,7} , {2,5,3} , {6,8,3} };
        DummyMatrix M2 = new DummyMatrix(3,3, Matrix);
        try {
            DummyMatrix M5 = M1.mul(M2);

            DummyMatrix M3 = M1.add(M2);
            DummyMatrix M4 = M1.sub(M2);
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
            DummyMatrix M6 = new DummyMatrix(3,3,in);
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
