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
public class Thread1 extends Thread{
    ArrayList<Integer> list1;
    int count;

    public Thread1() {
    }

    @Override
    public void run() {
        Random random = new Random();
        list1 = new ArrayList<>();
        count =0;
        for (int i = 0; i < 10; i++) {
            int a = random.nextInt(101);
            list1.add(a);
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    
}
