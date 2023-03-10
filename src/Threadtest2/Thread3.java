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
public class Thread3 extends Thread{
    Share share;

    public Thread3(Share share) {
        this.share = share;
    }

    @Override
    public void run() {
        synchronized (share) {
        while (share.check()){
            if (share.getRad()%2==0){
                try {
                    share.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                   
            if(share.getRad()%3==0){
                
                int a = share.getRad();
                a=a*a;
                System.out.println("T2:rad%3: "+a);  
            }
            
            
            share.notifyAll();
            try {
                share.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread3.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        }
    }
    
}
