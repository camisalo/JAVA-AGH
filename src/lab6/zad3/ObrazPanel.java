package lab6.zad3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ObrazPanel extends JPanel{

    private BufferedImage image;

    public ObrazPanel(){

    }

    public void ChangeImage(String patch){
        try {
            image = ImageIO.read(new File(patch));
            repaint();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }


}
