package lab1.zad7;

import java.io.IOException;

public class MatrixDimensionsException extends IOException {
    MatrixDimensionsException(){}
    MatrixDimensionsException(String gripe){ super(gripe);}
}
