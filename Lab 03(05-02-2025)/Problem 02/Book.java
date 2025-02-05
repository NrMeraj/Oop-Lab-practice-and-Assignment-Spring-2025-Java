package org.example;

public class Book {
    String title,author;
    int price;

    public Book(){

    }
    public Book(String title, String author){

        this.title = title;
        this.author = author;
    }
    public Book(String title, String author,int price){
        this.price = price;
        this.title = title;
        this.author = author;
    }
    void display(){
        System.out.println("\n");
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: "+price);
System.out.println("\n");

    }
}
