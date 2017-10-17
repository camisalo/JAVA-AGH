package lab4.zad5;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

class Cryptographer {
    static void cryptfile(String filetocrypt,
                                 String filetosave,
                                 Algorithm algorithm){
        try {
            Scanner reader = new Scanner(Paths.get(filetocrypt));
            String line;
            PrintWriter writter = new PrintWriter(filetosave);
            while (reader.hasNext()){
                line = reader.nextLine();
                writter.println(algorithm.crypt(line));
            }
            writter.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    static void decryptfile(String cryptedfile,
                                   String filetosave,
                                   Algorithm algorithm){
        try {
            Scanner reader = new Scanner(Paths.get(cryptedfile));
            String line;
            PrintWriter writter = new PrintWriter(filetosave);
            while (reader.hasNext()){
                line = reader.nextLine();
                writter.println(algorithm.decrypt(line));
            }
            writter.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
