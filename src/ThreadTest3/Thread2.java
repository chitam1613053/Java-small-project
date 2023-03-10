/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThreadTest3;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Thread2 extends Thread {
    ArrayList<Character> list2;
    ArrayList<Integer> list3;

    public Thread2() {
    }

    @Override
    public void run() {
         list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            char x = (char)getindex();
            list2.add(x);
        }
        
    }
    
    public int getindex(){
        list3 = new ArrayList<>();
        Random random = new Random();
        int a = (int)'a';
        int z = (int)'z';
        return random.nextInt(a, z);
    }
    
    
    
}
