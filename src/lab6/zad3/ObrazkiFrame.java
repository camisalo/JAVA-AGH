package lab6.zad3;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import org.apache.commons.io.FileUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ObrazkiFrame extends JFrame{
    LewyPanel LP = new LewyPanel();
    ObrazPanel OP = new ObrazPanel();
    PrawdopodobienstwoPanel PP = new PrawdopodobienstwoPanel();

    public ObrazkiFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(LP, BorderLayout.WEST);
        add(OP, BorderLayout.CENTER);
        add(PP, BorderLayout.EAST);
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
            PP.changeLabel(directory.getAbsolutePath() + "\\" + S);
        }
    }


    public class PrawdopodobienstwoPanel extends JPanel {
        JLabel p1 = new JLabel();
        JLabel p2 = new JLabel();
        JLabel p3 = new JLabel();
        JLabel p4 = new JLabel();
        JLabel p5 = new JLabel();
        JLabel p6 = new JLabel();
        JLabel p7 = new JLabel();
        JLabel p8 = new JLabel();
        JLabel p9 = new JLabel();
        JLabel p10 = new JLabel();

        public PrawdopodobienstwoPanel() {
            setLayout(new GridLayout(10, 1));
            add(p1);
            add(p2);
            add(p3);
            add(p4);
            add(p5);
            add(p6);
            add(p7);
            add(p8);
            add(p9);
            add(p10);
        }

        public void changeLabel(String patch) {
            Map<String, Double> Mapa = new HashMap<String, Double>();
            try {
                Mapa = Segregowanie(patch);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LinkedList<String> lista = new LinkedList<>();
            if (!Mapa.isEmpty()) {
                for(Map.Entry<String, Double> entry:Mapa.entrySet()) {
                    lista.add(entry.getValue() + "::::::::::" + entry.getKey());
                }
                p1.setText(lista.get(0));
                p2.setText(lista.get(1));
                p3.setText(lista.get(2));
                p4.setText(lista.get(3));
                p5.setText(lista.get(4));
                p6.setText(lista.get(5));
                p7.setText(lista.get(6));
                p8.setText(lista.get(7));
                p9.setText(lista.get(8));
                p10.setText(lista.get(9));
            }
        }

        public Map<String, Double> Segregowanie(String patch) throws IndicoException, IOException {

            Indico indico = new Indico("a16f7a067abf922404162ad6a6064bfa");

            File f = new File(patch);
            IndicoResult single = indico.imageRecognition.predict(f);
            Map<String, Double> result = single.getImageRecognition();

            String key = Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getKey();

            return result.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }
    }
}
