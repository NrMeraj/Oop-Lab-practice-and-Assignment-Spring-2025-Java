import java.util.Scanner;
import java.lang.Math;

public class Main{
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
      Circle r = new Circle();
      System.out.print("Enter a Radius: ");
        r.radius = input.nextFloat();
        r.display();
        r.area(r.radius);
        r.circumference(r.radius);
        
    }
}