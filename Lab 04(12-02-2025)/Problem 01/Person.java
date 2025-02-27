public class Person {

   public String myname;
   public int age;
    public String getMyname(){
        return myname;

   }
   public Person(){
System.out.println("Default");
   }
   public Person(String myname,int age){
        this.myname = myname;
        this.age = age;

   }
   public void setName(String newname){

        this.myname = newname;
   }
}
