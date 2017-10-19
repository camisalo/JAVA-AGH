package lab4.zad2;

import lab1.zad6.PESEL;

public class PracownikEtatowy extends Pracownik {

    PracownikEtatowy(){
        pesel = new PESEL();
        while (!pesel.check()) {
            pesel.LoadPESEL();
        }
    }

    public double obliczWynagrodzenieNeto(){
        return wynagrodzenieBrutto*0.80;
    }

}
