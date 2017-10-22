package lab3.zad4;

public class trojkat extends Shape{

    public trojkat(int a, int h){

        this.pole = (int) 0.5*a*h;
        name = "trojkat";
    }

    public void draw(){
        for (int i=0;i<10;++i){
            System.out.println("Rysuje trójkąt");
        }
    }
    public int pole(){
        return pole ;
    }

}
