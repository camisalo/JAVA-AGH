package lab2.PrDom;

import java.util.LinkedList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InteliCwDB extends CwDB {

  public InteliCwDB(String filename){
    super(filename);
  }

  public LinkedList<Entry> findAll(String pattern){
    LinkedList<Entry> temp = new LinkedList<>();
    Pattern p = Pattern.compile(pattern);
    for (Entry i:dict){
      Matcher m = p.matcher(i.getWord());
      if (m.matches()){
        temp.add(i);
      }
    }
    return temp;
  }

  public Entry getRandom(){
    Random R = new Random();
    R.setSeed(this.getSize());
    int i = R.nextInt();
    return dict.get(i);
  }

  public Entry getRandom(int length){
    Random R = new Random();
    R.setSeed(this.getSize());
    int i = R.nextInt();
    return dict.get(i);
  }

  public Entry getRandom(String pattern){
    LinkedList<Entry> temp = findAll(pattern);
    Random R = new Random();
    R.setSeed(temp.size());
    int i = R.nextInt();
    return temp.get(i);
  }
}
