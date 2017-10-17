package lab4.zad5;

public class ROT11 implements Algorithm{
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public String crypt(String word){
        word = word.toLowerCase();
        word = word.replace(" ","");
        String crypted=""; int ascii;
        for (int i=0;i<word.length();++i){
            ascii = (int)word.charAt(i);
            if ( 110 > ascii)
                crypted += Character.toString((char) (ascii+13));
            else
                crypted += Character.toString((char) (ascii-13));
        }
        return crypted;
    }

    public String decrypt(String crypted){
        String decrypted=""; int ascii;
        for (int i=0;i<crypted.length();++i){
            ascii = (int)crypted.charAt(i);
            if ( 110 > ascii)
                decrypted += Character.toString((char) (ascii+13));
            else
                decrypted += Character.toString((char) (ascii-13));
        }
        return decrypted;
    }

}

