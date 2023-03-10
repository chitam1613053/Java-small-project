/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threadtest2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Thread2 extends Thread{
    Share share;

    public Thread2(Share share) {
        this.share = share;
    }

    @Override
    public void run() {
        synchronized (share) {
        while(share.check()){
            if (share.getRad()%3==0){
                try {
                    share.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(share.getRad()%2==0){
                if(share.getRad()%4==0){
                    System.out.println("T%2: chia het cho 4");
                } else System.out.println("t%2: KHONG chia het cho 4");
            }
            share.notifyAll();
            try {
                share.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }
    
    
}
