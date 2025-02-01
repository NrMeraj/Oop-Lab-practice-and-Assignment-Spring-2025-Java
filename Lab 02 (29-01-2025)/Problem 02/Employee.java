public class Employee{

    String name;
    String title;
    int salary;

    void incrementsalary()
    {
        System.out.println("Increment Salary "+(salary+5000));

    }

    void calculateYearlysalary(){

        System.out.println("Calculate Yearly Salary "+(salary*12));
    }


    void display(){
        System.out.print("\n");
        System.out.println("Name: "+name);
        System.out.println("Job title: "+title);
        System.out.println("Salary: "+salary);

    }

}
