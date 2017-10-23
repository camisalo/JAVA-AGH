package lab5.zad2;

import lab1.zad7.Matrix;
import lab1.zad7.MatrixDimensionsException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DummyMatrix extends Matrix {
    int rows, columns;
    public int[][] M;


    public DummyMatrix(int _rows, int _columns, int[][] A){
        this(_rows,_columns);
        M = Arrays.copyOf(A, A.length);
    }

    public DummyMatrix(int _rows, int _columns){
        rows = _rows; columns = _columns;
        M = new int[rows][columns];
    }
    public DummyMatrix(int rows, int columns, Scanner in) throws IOException{
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






    public DummyMatrix add(Matrix _M) throws MatrixDimensionsException {
        if (this.getColumns() != _M.getColumns() ||
                this.getRows() != _M.getRows()) {
            throw new MatrixDimensionsException(BuildWrongMatrixaddsub(this.getColumns(),_M.getColumns(),this.getRows(),_M.getRows()));

        }
        DummyMatrix M_new = new DummyMatrix(rows,columns);
        for (int i=0;i<rows;++i){
            for (int j=0;j<columns;++j){
                M_new.setElement(i,j,M[i][j] + _M.getElement(i,j));
            }
        }

        return M_new;
    }

    public DummyMatrix sub(Matrix _M) throws MatrixDimensionsException {
        if (this.getColumns() != _M.getColumns() &&
                this.getRows() != _M.getRows()) {
            throw new MatrixDimensionsException(BuildWrongMatrixaddsub(this.getColumns(),_M.getColumns(),this.getRows(),_M.getRows()));
        }

        DummyMatrix M_new = new DummyMatrix(rows,columns);
        for (int i=0;i<rows;++i){
            for (int j=0;j<columns;++j){
                M_new.setElement(i,j,M[i][j] - _M.getElement(i,j));
            }
        }
        return M_new;
    }

    public DummyMatrix mul(Matrix _M) throws MatrixDimensionsException {
        if (this.getColumns() != _M.getRows()) {
            throw new MatrixDimensionsException(BuildWrongMatrixmul(this.getColumns(),_M.getColumns(),this.getRows(),_M.getRows()));
        }
        DummyMatrix M_new = new DummyMatrix(rows,columns);
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

    public String BuildWrongMatrixaddsub(int c1, int c2, int r1, int r2){
        int rmax, rmin, cmax, cmin;
        if (c1>c2){
            cmax = c1; cmin = c2;
        } else {
            cmax = c2; cmin = c1;
        }
        if (r1>r2) {
            rmax = r1; rmin = r2;
        } else {
            rmax = r2; rmin = r1;
        }
        String out = "Wynikowa macierz dodawania/odejmowania bez uwzględnienia błędu:\n[";
        for (int i=0;i<rmax;++i){
            if (i<rmin) {
                for (int j = 0; j < cmax; ++j) {
                    out += "1, ";
                }
            } else{
                for (int j = 0; j < cmin; ++j){
                    out += "1, ";
                }
            }
            if (i < rmax-1)
                out += "\n";
        }
        out += "]";
        return out;
    }
    public String BuildWrongMatrixmul(int c1, int c2, int r1, int r2){
        String out = "Wynikowa macierz mnozenia bez uwzględnienia błędu:\n[";
        for (int i=0;i<r1;++i){
            for (int j=0;j<c2;++j){
                out += "1, ";
            }
            if (i < r1-1)
                out += "\n";
        }
        out += "]";
        return out;
    }
}
