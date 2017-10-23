package lab1.zad7;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    int rows, columns;
    public int[][] M;

    public Matrix(){}

    public Matrix(int _rows, int _columns, int[][] A){
        this(_rows,_columns);
        M = Arrays.copyOf(A, A.length);
    }

    public Matrix(int _rows, int _columns){
        rows = _rows; columns = _columns;
        M = new int[rows][columns];
    }
    public Matrix(int rows, int columns, Scanner in) throws IOException{
        this(rows,columns);

        for (int r=0;r<rows;++r){
            for (int c=0;c<columns;++c){
                M[r][c] = in.nextInt();
                System.out.println(M[r][c]);
            }
            if (in.hasNextLine())
                in.nextLine();
        }
        in.close();
    }






    public Matrix add(Matrix _M) throws MatrixDimensionsException {
        if (this.getColumns() != _M.getColumns() &&
                this.getRows() != _M.getRows()) {
            throw new MatrixDimensionsException("Błędny wymiar macierzy");
        }
        Matrix M_new = new Matrix(rows,columns);
        for (int i=0;i<rows;++i){
            for (int j=0;j<columns;++j){
                M_new.setElement(i,j,M[i][j] + _M.getElement(i,j));
            }
        }
        return M_new;
    }

    public Matrix sub(Matrix _M) throws MatrixDimensionsException{
        if (this.getColumns() != _M.getColumns() &&
                this.getRows() != _M.getRows()) {
            throw new MatrixDimensionsException("Błędny wymiar macierzy");
        }
        Matrix M_new = new Matrix(rows,columns);
        for (int i=0;i<rows;++i){
            for (int j=0;j<columns;++j){
                M_new.setElement(i,j,M[i][j] - _M.getElement(i,j));
            }
        }
        return M_new;
    }

    public Matrix mul(Matrix _M) throws MatrixDimensionsException{
        if (this.getColumns() != _M.getRows()) {
            throw new MatrixDimensionsException("Błędny wymiar macierzy");
        }
        Matrix M_new = new Matrix(rows,columns);
        int sum;
        for (int i=0;i<rows;++i){
            for (int j=0;j<columns;++j){
                sum = 0;
                for (int k=0;k<columns;++k){
                    sum += M[i][k] * _M.getElement(k,j);
                }
                M_new.setElement(i,j,sum);
            }
        }
        return M_new;
    }

    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }
    public int getElement(int rows, int columns){
        return M[rows][columns];
    }
    public void setElement(int rows, int columns,int number){
        M[rows][columns] = number;
    }

    public void print(){
        for (int i=0;i<rows;++i) {
            System.out.println(Arrays.toString(M[i]));
        }
    }
}
