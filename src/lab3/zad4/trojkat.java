package lab3.zad4;

public class trojkat extends Shape{

    public trojkat(){
        name = "trojkat";
    }

    public void draw(){
        for (int i=0;i<10;++i){
            System.out.println("Rysuje trójkąt");
        }
    }
}
