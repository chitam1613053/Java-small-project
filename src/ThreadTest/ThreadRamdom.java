/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThreadTest;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ThreadRamdom extends Thread {
    int rad;
    
    Sharedata sharedata;

    public ThreadRamdom() {
    }

    public ThreadRamdom(Sharedata sharedata) {
        this.sharedata = sharedata;
    }

    @Override
    public void run() {
        Random random = new Random();
        
        for (int i = 0; i < 10; i++) {
            synchronized(sharedata){
                
            rad = random.nextInt(40)+1;
            sharedata.setRad(rad);
            System.out.println("RAD:"+rad);
            sharedata.notifyAll();
                try {
                    sharedata.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadRamdom.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }   
        }
        synchronized(sharedata){
            sharedata.notifyAll();
        }
    
    }


    
    
}
