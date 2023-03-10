/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lesson3;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class zzzHashmap {
    
    public static void main(String[] args) {
        
        HashMap<String,Student> Hstudentlist = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int choose;
        do{Getmenu();
        choose = Integer.parseInt(scan.nextLine());
         switch (choose){
             case 1: 
                 System.out.println("How many student do you want to insert?");
                 int N = Integer.parseInt(scan.nextLine());
                 for (int i = 0; i < N; i++) {
                     
                     System.out.println("--------\n Enter student");
                 Student std = new Student();
                 std.input();
                 Hstudentlist.put(std.getRollNo(), std);
                 break;
                 }
             case 2: 
                 Set<String> keys = Hstudentlist.keySet();
                 
                 for (String key : keys) {
                     System.out.println(Hstudentlist.get(key));
                     
                 }
                 
                 break;
             case 3:
                 System.out.println("Enter the RollNo of student");
                 String search = scan.nextLine();
                 Set<String> keyaa = Hstudentlist.keySet();
                 for (String key : keyaa) {
                     if(key.equalsIgnoreCase(search)){
                         System.out.println(Hstudentlist.get(key));
                     }
                     
                     
                 }
                 break;
             case 4:
                 System.out.println("Exit!!!");
                 break;
             default: System.out.println("choose again");
         }
            
            
            
        }while(choose !=4);
        
        
        
        
    }
    
    static void Getmenu(){
        System.out.println("------Menu------");
        System.out.println("1.Insert N student");
        System.out.println("2. print student list");
        System.out.println("3. Search studdent");
        System.out.println("4. Exit");
        System.out.println("choose...");
    }
    
}
