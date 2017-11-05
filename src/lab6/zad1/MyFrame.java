package lab6.zad1;

import javax.swing.*;

public class MyFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 800;

    public MyFrame(){
        add(new MyPanel());
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }

}
