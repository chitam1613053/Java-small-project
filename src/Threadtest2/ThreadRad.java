/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threadtest2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ThreadRad extends Thread{
    Share share;
    Random random = new Random();

    public ThreadRad(Share share) {
        this.share = share;
    }

    @Override
    public void run() {
        synchronized (share) {
            
            
            while(share.check()){
            int rad = random.nextInt(100)+1;
            share.setRad(rad);
            share.sum(rad);
            System.out.println("Random: "+rad);
            
          share.notifyAll();
            try {
                share.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadRad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            share.notifyAll();
        }
    }
  
    
    
}
