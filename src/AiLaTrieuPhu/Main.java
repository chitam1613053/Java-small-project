/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AiLaTrieuPhu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Main {
    static Scanner scan2 = new Scanner(System.in);
    public static void main(String[] args) {
        int choose;
        do{showmenu();
        choose = Integer.parseInt(scan2.nextLine());
        switch(choose){
            case 1 -> Insertquestion();
            case 2 -> Playgame();
            case 3 -> System.out.println("Good bye!!!!");
            default -> System.err.println("choose Error, choose again!");
        }   
            
        }while(choose!=3);
        
        
    }
    
    static void showmenu(){
        System.out.println("-----Menu----");
        System.out.println("1. Insert question");
        System.out.println("2. Play");
        System.out.println("3. Exit!!");
        System.out.println("choose: ");
    }
////////////////////////////////// Insert Question
    static void Insertquestion() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
                fos = new FileOutputStream("questions.dat", true);
                oos = new ObjectOutputStream(fos);
            for ( ; ; ) {

                Question question = new Question();
                question.input();
                oos.writeObject(question);
                System.out.println("do you want add more question? 1?2");
                int a = Integer.parseInt(scan2.nextLine());
                if (a==2)break;
                        
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    /////////////////

    private static void Playgame() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Question> list = new ArrayList<>();
        try {
            fis = new FileInputStream("questions.dat");
            ois = new ObjectInputStream(fis);
            for(;;){
                Object obj = ois.readObject();
                if(obj==null) break;
                list.add((Question)obj);
            }
          
            
        } catch (FileNotFoundException ex) {
            
        } catch (IOException | ClassNotFoundException ex) {
            
        }finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }////////////////////////////      
        Random random = new Random();
        ArrayList<Question> tamp = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(list.size());
            tamp.add(list.get(index));
        }
        list = tamp;

        //////////////
        int correct =0;
        int total = list.size();
        for (Question question : list) {
            question.showquestion();
            int as = Integer.parseInt(scan2.nextLine());
            if(question.checkresult(as)){
                correct++;
            }
            System.out.format("your score: %d/%d\n",correct,total);
        }
        System.out.format("\n---------Congrastulation! Your score is: %d/%d---------\n",correct,total);
        
        
    }
    
   
}
