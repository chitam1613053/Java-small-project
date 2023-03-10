/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilequanlySach;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Main {
    public static List<Book> booklist = new ArrayList<>();
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int choose;
        
        do{
            Getmenu();
            choose = Integer.parseInt(scan.nextLine());
            switch(choose){
                case 1:
                    System.out.println("how many book do you want Insert?");
                    int N = Integer.parseInt(scan.nextLine());
                    for (int i = 0; i < N; i++) {
                        System.out.format("Enter book No%d:",i+1);
                        Book book = new Book();
                        book.input();
                        booklist.add(book);   
                    }
                    break;
                case 2:
                    for (Book a : booklist) {
                        a.display();
                    }
                    break;
                case 3:
                    Collections.sort(booklist, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                   return o1.getAuthor().compareToIgnoreCase(o2.getAuthor());
                }
            });
                    for (Book book : booklist) {
                        book.display();
                        
                    }                  
                    break;
                case 4:
                  save(booklist);
                    break;
                case 5:
                    read();
                    break;
                case 6:
                    readtobooklist();
                    for (Book book:booklist) {
                        book.display();
                    }
                case 7:
                    System.out.println("Exit!!!");
                    break;
                default: System.err.println("out of menu, choose again:");
            }
            
        }while(choose != 7);
        
        
    }
    
    static void Getmenu(){
        System.out.println("----------Menu--------");
        System.out.println("1. Insert Book"); 
        System.out.println("2. Display book");
        System.out.println("3. Sort by author");
        System.out.println("4. Save in file data.txt");
        System.out.println("5. Read in file data.txt");
        System.out.println("6. Read in file data.txt and add data to boooklist");
        System.out.println("7. Exit");
        System.out.println("choose....");
    }

    private static void save(List<Book> booklist) {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("book.txt");
            for (Book book : booklist) {
                String str = book.toString() + "\n";
                byte[] data = str.getBytes();
                try {
                    fout.write(data);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    private static void read() {
        FileReader fin = null;
        BufferedReader buf = null;

        try {
            fin = new FileReader("book.txt");
            buf = new BufferedReader(fin);
            String line;
            try {
                while ((line = buf.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (buf != null) {
                try {
                    buf.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private static void readtobooklist() {
        FileInputStream fin = null;
        InputStreamReader inp = null;
        BufferedReader buf = null;

        try {
            fin = new FileInputStream("book.txt");
            inp = new InputStreamReader(fin, StandardCharsets.UTF_8);
            buf = new BufferedReader(inp);

            String line;

            while ((line = buf.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Book book = new Book();
                book.Parse(line);
                booklist.add(book);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (inp != null) {
                try {
                    inp.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (buf != null) {
                try {
                    buf.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
