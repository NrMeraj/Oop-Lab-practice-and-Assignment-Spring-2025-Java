import java.util.*;

public class Main {
  
  static void prime_number(int a){
    
    int prime = 0;
    for(int i =2; i<a/2; i++)
    {
      if(a%i ==0)
      prime=1;
    }
    if(prime ==0)
    {
      System.out.print(a +" Prime Number");
    }
    else
    {
      System.out.print(a +" Not prime Number");
    }
  }
    public static void main(String[] args) {

      int[] a = {5,7,8,11,17,40};
      int sum=0;
      for(int i=0; i<a.length; i++){
      sum+=a[i];
      }
       System.out.print("\n");
      System.out.println("Sum "+sum);
      System.out.println("\nAverage "+sum/a.length);
      
      System.out.print("\nOdd Number: ");
    for(int i=0; i<a.length; i++){
      if(a[i]%2 != 0)
      
      System.out.print(a[i] +" ");
    }
     System.out.print("\n");
    System.out.print("\nEven Number: ");
    for(int i=0; i<a.length; i++)
    {
      if(a[i]%2 == 0)
      System.out.print(a[i] +" ");
    }
     System.out.print("\n");
    int sum1=0;
    for(int i = 1; i<=100; i++)
    {
      sum1+=i;   
      }
      
      System.out.print("\nSum of 100: "+sum1);
      
    System.out.println("Multiuplication table of 25: ");
    int m =25;
    {
      for(int i=1; i<=10; i++)
      System.out.println(i+"x"+m+"="+(m*i));
    }
    System.out.print("\n");
    int b = 7;
    int c = 11;
    int d = 2;
    
    if(b>c && b>d)
    {
      System.out.print(b +" is maximum");
    }
    else if(c>d && c>d)
    {
      System.out.println(c +" is maximum");
    }
    else{
      System.out.print(d +" is maximub");
    }
    prime_number(20);
    
    
    
    
    
    
}

}