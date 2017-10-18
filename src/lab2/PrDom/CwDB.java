package lab2.PrDom;


import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;



public class CwDB {

    protected LinkedList<Entry> dict = new LinkedList<Entry>();

    public CwDB(String filename){
        createDB(filename);
    }

    public void add(String word, String clue){
        Scanner in = new Scanner(System.in);
        String _word = in.nextLine();
        String _clue = in.nextLine();
        Entry E = new Entry(_word, _clue);
        dict.add(E);
    }

    public Entry get(String word){
        for (Entry i:dict){
            if (i.equals(word)){
                return i;
            }
        }
        return null;
    }

    public void remove(String word){
        for (Entry i:dict){
            if (i.equals(word)){
                dict.remove(word);
            }
        }
    }

    public void saveDB(String filename){
        try{
            PrintWriter file = new PrintWriter(filename);
            for (Entry e:dict){
                file.println(e.getWord());
                file.println(e.getClue());
            }
        }catch(FileNotFoundException e){System.out.print("File not found.");}
    }

    public int getSize(){
        return dict.size();
    }

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
