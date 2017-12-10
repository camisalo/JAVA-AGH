package lab5.zad6;

import io.indico.api.utils.IndicoException;

import java.io.IOException;

public class TestIndico {
    public static void main(String[] args) {
        try {
            SegregowanieZdjec S = new SegregowanieZdjec("C:\\foto");
        } catch (IndicoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}