package lab5;

import lab5.zad3.MicroDVD;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MicroDVDTest {
    @Test
    void delay() {
        MicroDVD M = new MicroDVD();
        String in = "C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab5\\zad3\\Subtitles.txt";
        String out = "C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab5\\zad3\\Subtitles_delay";
        String out_test = "C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\Tests\\lab5\\Subtitles_Test";
        M.delay(in, out, 500, 30);

        try {
            Scanner poprawne = new Scanner(Paths.get(out_test));
            Scanner sprawdzane = new Scanner(Paths.get(out));


            while (poprawne.hasNext() && sprawdzane.hasNext()){
                assertEquals(poprawne.nextLine(),sprawdzane.nextLine());
            }
        }catch(IOException e){
            e.printStackTrace();
        } finally {
            System.out.println("koniec");
        }
    }


    @Test
    void calcFrameToMove() {
        MicroDVD M = new MicroDVD();
        String in = "C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab5\\zad3\\Subtitles.txt";
        String out = "C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\src\\lab5\\zad3\\Subtitles_delay";
        String out_test = "C:\\Users\\konra\\IdeaProjects\\JAVA-AGH\\Tests\\lab5\\Subtitles_Test";
        M.delay(in, out, 500, 30);
        assertEquals(15, M.getFrameToMove());
    }

}