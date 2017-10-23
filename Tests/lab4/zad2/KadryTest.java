package lab4.zad2;

import lab1.zad6.PESEL;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KadryTest {
    @Test
    void dodajPracownika() {
        Kadry K = new Kadry();
        Student S = new Student("94010408952");
        K.dodajPracownika(S);
        K.zmienWynagrodzenie(S,45000);

        assertEquals(45000,K.pobierzWynagrodzenieBrutto(S));
    }

    @Test
    void usunPracownika() {
        Kadry K = new Kadry();
        Student S = new Student("94010408952");
        Student S1 = new Student("94012348952");
        K.dodajPracownika(S1);
        K.dodajPracownika(S);
        PESEL p = new PESEL();
        p.LoadPESEL("94012348952");
        K.usunPracownika(p);
        K.zmienWynagrodzenie(S,23333);
        K.zmienWynagrodzenie(S,45000);

        assertEquals(45000,K.pobierzWynagrodzenieBrutto(S));
    }

    @Test
    void zmienWynagrodzenie() {
        Kadry K = new Kadry();
        Student S = new Student("94010408952");
        Student S1 = new Student("94012348952");

        K.dodajPracownika(S);
        K.zmienWynagrodzenie(S,23333);
        K.zmienWynagrodzenie(S,45000);

        assertEquals(45000,K.pobierzWynagrodzenieBrutto(S));
    }

    @Test
    void pobierzWynagrodzenieBrutto() {
        Kadry K = new Kadry();
        Student S = new Student("94010408952");
        K.dodajPracownika(S);
        K.zmienWynagrodzenie(S,45000);

        assertEquals(45000,K.pobierzWynagrodzenieBrutto(S));
    }

    @Test
    void pobierzWynagrodzenieNetto() {
        Kadry K = new Kadry();
        Student S = new Student("94010408952");
        K.dodajPracownika(S);
        K.zmienWynagrodzenie(S,45000);

        assertEquals(45000,K.pobierzWynagrodzenieBrutto(S));
    }

}