package lab4.zad5;

public class Polibiusz implements Algorithm {
    private static String szyfr = "abcdefghiklmnopqrstuvwxyz";
    public String crypt(String word){
        String crypted="";
        word = word.toLowerCase();word = word.replace(" ","");
        for (int i=0;i<word.length();++i){
            int counter=0;
            while(word.charAt(i) != szyfr.charAt(counter) && counter <= 23){
                if (counter == 8 && word.charAt(i) == 'j')
                    break;
                counter++;
            }
            crypted += (1+(int)counter/5) + "" + ((counter%5)+1) + " ";
        }
        return crypted;
    }

    public String decrypt(String crypted){
        String decrypted="";int a,b;
        for (int i=0;i<crypted.length()/3;++i){
            a = Integer.parseInt(crypted.substring(i*3,i*3+1));
            b = Integer.parseInt(crypted.substring(i*3+1,i*3+2));
            decrypted += szyfr.charAt(5*(a-1) + (b-1));
        }
        return decrypted;
    }
}
