package lab5.zad3;

import java.io.IOException;

public class WrongFrameFormat extends IOException {
    public WrongFrameFormat(){}
    public WrongFrameFormat(String gripe){
        super(gripe);
    }
}
