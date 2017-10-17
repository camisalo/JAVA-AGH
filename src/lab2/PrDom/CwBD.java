package lab2.PrDom;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;


public class CwBD {

    protected LinkedList<Entry> dict = new LinkedList<Entry>();

    public CwBD(String filename){
        createDB(filename);

    }

    public void add(String word, String clue){
        Scanner in = new Scanner(System.in);
        String _word = in.nextLine();
        String _clue = in.nextLine();
        Entry E = new Entry(_word, _clue);
        dict.add(E);
    }
//
//    public Entry get(String word){
//
//    }
//
//    public void remove(String world){
//
//    }
//
//    public void saveDB(String filename){
//
//    }
//
//    public int getSize(){
//
//    }

    protected void createDB(String filename){
        try{
            FileReader file = new FileReader(filename);
            Scanner in = new Scanner(file);
            String word ="a", clue;
            while (in.hasNext()) {
                word = in.nextLine();
                clue = in.nextLine();
                Entry E = new Entry(word, clue);
                System.out.println(word + " ::::: " + clue);
                dict.add(E);
            }

        }catch(FileNotFoundException e){System.out.print("File not found.");}
    }

}
