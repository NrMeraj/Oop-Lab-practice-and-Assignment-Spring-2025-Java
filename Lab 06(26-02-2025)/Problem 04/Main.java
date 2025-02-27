public class Main {
    public static void main(String[] args) {
        String[] bookTitles = {"Anime", "Manga", "One Piece"};
        Library library = new Library(bookTitles);
        System.out.println("Library Books:");
        library.showBooks();

        System.out.println();
        Member member = new Member("Zoro");
        LibrarySystem system = new LibrarySystem(member);
        system.showMember();
    }
}