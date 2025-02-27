public class Library {
    private Book[] books;

    Library(String[] bookTitles) {
        books = new Book[bookTitles.length];
        for (int i = 0; i < bookTitles.length; i++) {
            books[i] = new Book(bookTitles[i]);
        }
    }

    void showBooks() {
        for (Book book : books) {
            book.displayBook();
        }
    }
}


