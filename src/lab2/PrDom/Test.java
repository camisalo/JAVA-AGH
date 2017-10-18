package lab2.PrDom;

public class Test {

    public static void main(String[] args) {
        CwDB C = new CwDB("C:/hasla.txt");
        C.add("cegła", "podstawowy materiał budowlany");
        C.remove("cegła");
    }
}

