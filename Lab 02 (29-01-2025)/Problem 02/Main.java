import java.util.Scanner;
import java.lang.Math;

public class Main{

    public static void main(String[] args){


        Scanner input = new Scanner(System.in);

        Employee em = new Employee();
        System.out.print("Employee Name: ");
        em.name = input.nextLine();

        System.out.print("Job Title: ");
        em.title = input.nextLine();

        System.out.print("Salary: ");
        em.salary = input.nextInt();



        em.display();
        em.calculateYearlysalary();
        em.incrementsalary();



    }
}