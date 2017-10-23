package lab4.zad2;

import lab1.zad6.PESEL;

public class Student extends Pracownik {


    Student(String p){
        pesel = new PESEL();
        pesel.LoadPESEL(p);
    }

    public double obliczWynagrodzenieNetto(){
        return wynagrodzenieBrutto*0.80;
    }

    public double pobierzWynagrodzenieBrutto(){
        return wynagrodzenieBrutto;
    }

    public void zmienwynagrodzenie(double wynagrodzenie){
        wynagrodzenieBrutto = wynagrodzenie;
    }

}
