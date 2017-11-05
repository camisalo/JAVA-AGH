package lab5.zad3;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MicroDVD {
    private Scanner source;
    private PrintWriter out;
    private int frametomove;
    public void delay(String in, String out, int delay, int fps) throws IOException, WrongFrame, WrongFrameFormat{
        calcFrameToMove(delay,fps);
        try{
            source = new Scanner(Paths.get(in));
            this.out = new PrintWriter(out);
            moveFrame();
        }
        catch (IOException e){
            e.printStackTrace();
            throw e;
        }
        finally {
            source.close();
            this.out.close();
        }
    }


    private void calcFrameToMove(int delay, int fps) {
        frametomove = (int) (0.001 * delay * fps);
    }

    private void moveFrame() throws IOException, WrongFrame, WrongFrameFormat{
        Pattern p = Pattern.compile("(\\{[0-9]{1,}\\})(\\{[0-9]{1,}\\})");
        String line;
        while (source.hasNext()){
            line = source.nextLine();
            Matcher m = p.matcher(line);
            System.out.println(line);
            if (m.find()){
                if (Integer.parseInt(line.substring(m.start(1)+1,m.end(1)-1)) >
                        Integer.parseInt(line.substring(m.start(2)+1,m.end(2)-1))) {
                    throw new WrongFrame("Niepoprawna kolejność klatek: " + line);
                }
                out.println("{" + (Integer.parseInt(line.substring(m.start(1)+1,m.end(1)-1))+frametomove) +
                        "}{" +
                        (Integer.parseInt(line.substring(m.start(2)+1,m.end(2)-1))+frametomove) +
                        line.substring(m.end(2)-1,line.length()));
            } else
                throw new WrongFrameFormat("Niepoprawny format danychw wlinijce: " + line);
        }
    }

    public int getFrameToMove(){
        return frametomove;
    }
}