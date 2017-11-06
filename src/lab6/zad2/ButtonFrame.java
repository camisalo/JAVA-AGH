package lab6.zad2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame extends JFrame{
    private JPanel panel = new JPanel();

    private JTextField A = new JTextField("0.1");
    private JTextField B = new JTextField("2");
    private JTextField C = new JTextField("1");
    private JTextField D = new JTextField("0");
    private JTextField S = new JTextField("-20");
    private JTextField E = new JTextField("5");
    private JTextField div = new JTextField("100");

    public ButtonFrame(){
        JButton PlotButton = new JButton("Rysuj");
        PlotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(() ->
                {
                    JFrame frame = new JFrame();
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    PanelWielomian wykres = new PanelWielomian();
                    wykres.LoadABCD(Double.parseDouble(A.getText()),
                            Double.parseDouble(B.getText()),
                            Double.parseDouble(C.getText()),
                            Double.parseDouble(D.getText()),
                            Double.parseDouble(S.getText()),
                            Double.parseDouble(E.getText()),
                            Integer.parseInt(div.getText()));
                    frame.add(wykres);


                    frame.setSize(1015,640);

                    frame.setTitle("Wykresy wielomianów");
                    frame.setVisible(true);
                });
            }
        });


        JLabel l = new JLabel("A * X^3 + B * X^2 + C*X + D", JLabel.CENTER);
        JLabel A1 = new JLabel("A", JLabel.CENTER);
        JLabel B1 = new JLabel("B", JLabel.CENTER);
        JLabel C1 = new JLabel("C", JLabel.CENTER);
        JLabel D1 = new JLabel("D", JLabel.CENTER);
        JLabel S1 = new JLabel("Start", JLabel.CENTER);
        JLabel E1 = new JLabel("Koniec", JLabel.CENTER);
        JLabel div1 = new JLabel("Podział", JLabel.CENTER);


        panel.setLayout(new GridLayout(8,2));

        panel.add(l);
        panel.add(PlotButton);
        panel.add(A1);
        panel.add(A);
        panel.add(B1);
        panel.add(B);
        panel.add(C1);
        panel.add(C);
        panel.add(D1);
        panel.add(D);
        panel.add(S1);
        panel.add(S);
        panel.add(E1);
        panel.add(E);
        panel.add(div1);
        panel.add(div);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setSize(400,300);
        setTitle("Wykresy wielomianów");
        setVisible(true);
    }
}
