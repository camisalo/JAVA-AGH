import lab4.zad5.Polibiusz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolibiuszTest {
    @Test
    void crypt() {
        Polibiusz P = new Polibiusz();
        String word = "Rocky";
        assertEquals("42 34 13 25 54 ", P.crypt(word));
    }

    @Test
    void decrypt() {
        Polibiusz P = new Polibiusz();
        String crypted = "42 34 13 25 54 ";
        assertEquals("rocky", P.decrypt(crypted));
    }

}// testkkg