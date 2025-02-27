public class Main{

    public static void main(String [] args){

        Author author = new Author("Niaur Rahman Meraj", "Adventure", "Fantasy");


        Book book = new Book("Harry Potter", "250tk", author);
        book.display();
    }
}