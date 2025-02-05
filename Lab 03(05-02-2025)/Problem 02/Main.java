package org.example;

import org.example.Book;

public class Main{

    public static void main(String[] args){

        Book b1 = new Book("JavaLan","Niamur", 210);
        b1.display();
        Book b2 = new Book("JavaLan","Niamur");
        Book b3 = new Book();
        b2.display();
        b3.display();
    }


}