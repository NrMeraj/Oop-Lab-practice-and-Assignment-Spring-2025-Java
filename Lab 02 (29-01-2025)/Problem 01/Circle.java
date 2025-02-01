public class Circle{


    float radius;
    void area(float r){
        radius =r;
        System.out.print("area = "+(Math.PI*radius*radius));

    }
    void circumference(float radius){

        System.out.println("\ncircumference = "+(Math.PI*2*radius));
    }
    void display(){
        System.out.println("Radius = "+radius);
    }

}
