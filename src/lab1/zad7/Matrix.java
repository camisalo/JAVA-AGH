package lab1.zad7;

import java.util.Arrays;

public class Matrix {
    int rows, columns;
    public int[][] M;

    public Matrix(int _rows, int _columns, int[][] A){
        this(_rows,_columns);
        M = Arrays.copyOf(A, A.length);
    }

    public Matrix(int _rows, int _columns){
        rows = _rows; columns = _columns;
        M = new int[rows][columns];
    }

    public Matrix add(Matrix _M){
        Matrix M_new = new Matrix(rows,columns);
        for (int i=0;i<rows;++i){
            for (int j=0;j<columns;++j){
                M_new.setElement(i,j,M[i][j] + _M.getElement(i,j));
            }
        }
        return M_new;
    }

    public Matrix sub(Matrix _M){
        Matrix M_new = new Matrix(rows,columns);
        for (int i=0;i<rows;++i){
            for (int j=0;j<columns;++j){
                M_new.setElement(i,j,M[i][j] - _M.getElement(i,j));
            }
        }
        return M_new;
    }

    public Matrix mul(Matrix _M){
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
