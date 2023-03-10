/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThreadTest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ThreadBP extends Thread{
    int rad;
    Sharedata sharedata;

    public ThreadBP() {
    }

    public ThreadBP(Sharedata sharedata) {
        this.sharedata = sharedata;
    }
    

    @Override
    public void run() {
        synchronized (sharedata) {
             for (int i = 0; i < 10; i++) {
        rad = sharedata.getRad();
        rad *=rad;
        System.out.println("BP:"+rad);
        
         sharedata.notifyAll();
            try {
                sharedata.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadBP.class.getName()).log(Level.SEVERE, null, ex);
            }
             }
            
        }
    }
    
    
}
