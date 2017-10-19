package lab4.zad2;

import lab1.zad6.PESEL;

abstract class Pracownik {
    PESEL pesel;
    double wynagrodzenieBrutto;

    abstract double obliczWynagrodzenieNeto();

}
