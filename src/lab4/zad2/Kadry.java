package lab4.zad2;

import lab1.zad6.PESEL;

import java.util.LinkedList;

public class Kadry {
    private LinkedList<Pracownik> lista = new LinkedList<>();
    public void dodajPracownika(Pracownik P){
        lista.add(P);
    }

    public void usunPracownika(PESEL pesel){
        int id=0;
        for (Pracownik p:lista) {
            if (p.pesel.getPesel().equals(pesel.getPesel())) {
                lista.remove(id);
                break;
            }
            id++;
        }

    }

    public void zmienWynagrodzenie(Pracownik P, double wynagrodzenie){
        for (Pracownik p:lista){
            if (p.pesel.getPesel().equals(P.pesel.getPesel())){
                p.zmienwynagrodzenie(wynagrodzenie);
            }
        }
    }

    public double pobierzWynagrodzenieBrutto(Pracownik P){
        for (Pracownik p:lista){
            if (p.pesel.getPesel().equals(P.pesel.getPesel())){
                return p.pobierzWynagrodzenieBrutto();
            }
        }
        return -1;
    }

    public double pobierzWynagrodzenieNetto(Pracownik P){
        for (Pracownik p:lista){
            if (p.pesel.getPesel().equals(P.pesel.getPesel())){
                return p.obliczWynagrodzenieNetto();
            }
        }
        return -1;
    }





}

