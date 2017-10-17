package lab1.zad5;

public class LiczbyPierwsze {

    public static void main(String [] argv){
        JIn P = new JIn();
        P.LoadNumber();
        boolean T;
        for (int i=2; i<P.number;++i){
            T = true;
            for (int k=2;k<i;++k){
                if (i%k == 0) {
                    T = false;
                    break;
                }
            }
            if (T)
                System.out.print(i + " ; ");
        }
    }
}
