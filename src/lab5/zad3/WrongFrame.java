package lab5.zad3;

import java.io.File;
import java.io.IOException;

public class WrongFrame extends IOException {
    public WrongFrame(){}
    public WrongFrame(String gripe){
        super(gripe);
    }
}

