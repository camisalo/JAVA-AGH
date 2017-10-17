package lab2.zad1.pkg1;

/*
W klasie B będą widoczne oba pola number i name.
Natomiast w klasie C jedynym widocznym polem jest name, ponieważ klasa C
znajduje się w innym pakiecie więc nie będzie posaiadać dostępu do pola number.
 */


public class A {
    int number=1;
    protected String name = "Siema";



}
