package lab2.zad2.pkg1;


public class A2 {
    protected int number;
    String name;

    public A2(int number, String name){ this.number = number; this.name = name; }
    public void callDecrement(){ decrement(); }
    public void callChangeName(){ changeName(); }
    public void callIncrement(){ increment(); }
    private void increment(){ number += 1; }
    protected void decrement(){ number -= 1; }
    void changeName(){ name = "Arkadiusz"; }
}
