public class Book {
    String title;
    String price;
    Author author;

    public Book(String title, String price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    void display() {
        System.out.println("Book Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Author Name: " + author.name);
        System.out.println("Fiction Name: " + author.fictionName);
    }
}

