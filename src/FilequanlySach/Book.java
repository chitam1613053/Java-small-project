/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilequanlySach;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Book {
    String bookname,author,daypublic,NXB;
    int price;

    public Book() {
    }

    public Book(String bookname, String author, String daypublic, String NXB, int price) {
        this.bookname = bookname;
        this.author = author;
        this.daypublic = daypublic;
        this.NXB = NXB;
        this.price = price;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDaypublic() {
        return daypublic;
    }

    public void setDaypublic(String daypublic) {
        this.daypublic = daypublic;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    /////////////////////////InPut
    public void input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter book name:");
        bookname =scan.nextLine();
        System.out.println("Enter author of book");
        author = scan.nextLine();
        System.out.println("Enter day public");
        daypublic = scan.nextLine();
        System.out.println("Enter NXB:");
        NXB = scan.nextLine();
        System.out.println("Enter the price of Book");
        price = Integer.parseInt(scan.nextLine());
    }

    @Override
    public String toString() {
        return bookname + ", "+author+", "+price+", "+ daypublic+ ", "+ NXB;
    }
    
    public void display(){
        System.out.println(toString());
    }
    
    public void Parse(String line){
        String [] paramater;
        paramater = line.split(", ");
        bookname = paramater[0];
        author = paramater[1];
        price = Integer.parseInt(paramater[2]);
        daypublic = paramater[3];
        NXB = paramater[4];
        
    }
    
}
