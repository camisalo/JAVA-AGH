package lab2.zad2;


import lab2.zad2.pkg1.*;
import lab2.zad2.pkg2.*;

public class main {
    public static void main(String[] args) {
        A2 a = new A2(10,"Konrad");
        B2 b = new B2 ();
        C2 c = new C2 ();

        a.callIncrement();
        a.callDecrement();
        a.callChangeName();

        b.callIncrement();
        b.callDecrement();
        b.callChangeName();

        c.callIncrement();
        c.callDecrement();
        c.callChangeName();

    }
}
