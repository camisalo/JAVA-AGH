package lab6.zad3;

import lab6.zad1.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Map;

public class Przeg_zdjecia {
    Map<String, Double> result;
    Przeg_zdjecia(){
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setTitle("przeglądarka zdjęć");

            frame.setVisible(true);
        });
    }

    private void LoadButtons(){


    }
}
