package lab6.zad1;

import javax.swing.*;
import java.awt.*;

public class MyPanelTest {

    public static void main(String[] args) {

        EventQueue.invokeLater(() ->
        {
            MyFrame frame = new MyFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setTitle("Kształty");

            frame.setVisible(true);
        });
    }
}
