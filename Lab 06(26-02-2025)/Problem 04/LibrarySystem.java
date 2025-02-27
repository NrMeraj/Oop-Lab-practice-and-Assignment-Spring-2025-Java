public class LibrarySystem {
    private Member member;

    LibrarySystem(Member member) {
        this.member = member;
    }

    void showMember() {
        System.out.println("Library Member: " + member.name);
    }
}

