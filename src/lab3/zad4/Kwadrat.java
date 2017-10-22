package lab3.zad4;

public class Kwadrat extends Shape {

    public Kwadrat(int a){
        this.pole = a*a;
        name = "Kwadrat";
    }




    public void draw(){
        System.out.println("----------");
        for (int i=0;i<4;++i){
            System.out.println("|          |");
        }
        System.out.println("----------");
    }
    public int pole(){
        return pole ;
    }

}
