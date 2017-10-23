package lab1.zad6;

public class PESELmain {
    public static void main(String[] args) {
        PESEL P = new PESEL();
        P.LoadPESEL("94010408952");
        if (P.check()){
            System.out.println("Ostatnia cyfra z sumy zgadza się z ostatnią cyfrą z pesleu. Pesel jest poprawny");
        } else{
            System.out.println("Niesiety pesel nie jest poprawny");
        }
    }
}
