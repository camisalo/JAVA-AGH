package lab6.zad3;

import org.apache.commons.io.FileUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

public class ObrazkiFrame extends JFrame{
    LewyPanel LP = new LewyPanel();
    ObrazPanel OP = new ObrazPanel();

    public ObrazkiFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(LP, BorderLayout.WEST);
        add(OP, BorderLayout.CENTER);
        setSize(800,500);
        setTitle("Wykresy wielomianów");
        setVisible(true);
    }



    public class LewyPanel extends JPanel implements ActionListener, ListSelectionListener {
        private File directory = new File("C:\\foto\\");
        private JLabel LPatch = new JLabel(directory.getAbsolutePath(), JLabel.LEFT);
        private JList list = new JList();
        private LinkedList<String> obrazki;


        public LewyPanel(){
            setLayout(new GridLayout(3,1));
            JButton button = new JButton("Ustaw Folder");
            button.addActionListener(this);
            add(button);

            add(LPatch); // dodatnie etykiety

            list.addListSelectionListener(this);
            JScrollPane scroll = new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            add(list);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();

            chooser.setCurrentDirectory(new File("C:\\"));
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                directory = chooser.getSelectedFile();
                LPatch.setText(directory.getAbsolutePath());


                String[] extension = {"jpg"};
                Iterator it = FileUtils.iterateFiles(directory, extension, false);
                DefaultListModel<String> DLM = new DefaultListModel<>();
                while(it.hasNext()){
                    File f = (File) it.next();
                    DLM.addElement(f.getName());
                }
                list.setModel(DLM);
            }
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String S = (String) list.getSelectedValue();
            OP.ChangeImage(directory.getAbsolutePath() + "\\" + S);
        }
    }

}
